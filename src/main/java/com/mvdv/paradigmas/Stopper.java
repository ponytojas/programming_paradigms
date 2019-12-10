package com.mvdv.paradigmas;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
            this.employeesLock.get(employeeID).lock();
            while(employeeStop.get(employeeID)){
                try{
                    this.stopEmployees.get(employeeID).await();
                }catch(InterruptedException e){}
            }
        }finally{
            this.employeesLock.get(employeeID).unlock();;
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
        this.employeeStop.set(employeeID, !this.employeeStop.get(employeeID));
        if(!this.employeeStop.get(employeeID))
            this.sendEmployeeSignal(employeeID);
    }

    public void setGlobalLock(){
        this.globalStop = !this.globalStop;
    }

    public void sendEmployeeSignal(int employeeID){
        this.stopEmployees.get(employeeID).signal();
    }

    public void sendGlobalSignal(){
        this.stopGlobal.signalAll();
    }
}