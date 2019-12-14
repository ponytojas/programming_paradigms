package com.mvdv.paradigmas;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */

public class Stopper {
    private Boolean globalStop;
    private Lock lockGlobal = new ReentrantLock();
    private Condition stopGlobal = lockGlobal.newCondition();

    private Lock lockEmployee1 = new ReentrantLock();
    private Lock lockEmployee2 = new ReentrantLock();
    private Condition stopEmployee1 = lockEmployee1.newCondition();
    private Condition stopEmployee2 = lockEmployee2.newCondition();
    private ArrayList<Boolean> employeeStop = new ArrayList<>();
    private ArrayList <Lock> employeesLock = new ArrayList<>();
    private ArrayList<Condition> stopEmployees = new ArrayList<>();
    
    Stopper() {
        this.employeeStop.add(false);
        this.employeeStop.add(false);
        this.globalStop = false;
        this.stopEmployees.add(this.stopEmployee1);
        this.stopEmployees.add(this.stopEmployee2);
        this.employeesLock.add(lockEmployee1);
        this.employeesLock.add(lockEmployee2);
    }

    public void checkEmployee(int employeeID){
        try{
            this.employeesLock.get(employeeID - 1).lock();
            while(employeeStop.get(employeeID - 1)){
                try{
                    this.stopEmployees.get(employeeID - 1).await();
                }catch(InterruptedException e){}
            }
        }finally{
            this.employeesLock.get(employeeID - 1).unlock();
        }
    }

    public void checkGlobal(){
        try{
            this.lockGlobal.lock();
            while(globalStop){
                try{
                    this.stopGlobal.await();
                }catch(InterruptedException e){}
            }
        }finally{
            this.lockGlobal.unlock();
        }
    }

    public void setEmployeeLock(int employeeID){
        if(!this.globalStop){
            this.employeeStop.set(employeeID, !this.employeeStop.get(employeeID));
            if(!this.employeeStop.get(employeeID))
                this.sendEmployeeSignal(employeeID + 1);
        }
    }

    public void setGlobalLock(){
        this.globalStop = !this.globalStop;
        if(!this.globalStop)
            this.sendGlobalSignal();
    }

    public void sendEmployeeSignal(int employeeID){
        try{
            this.employeesLock.get(employeeID - 1).lock();
            this.stopEmployees.get(employeeID - 1).signal();
        }finally{
            this.employeesLock.get(employeeID - 1).unlock();
        }
    }

    public void sendGlobalSignal(){
        try{
            this.lockGlobal.lock();
            this.stopGlobal.signalAll();
        }finally{
            this.lockGlobal.unlock();
        }
    }
}