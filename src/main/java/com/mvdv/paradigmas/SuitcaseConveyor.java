package com.mvdv.paradigmas;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */

public class SuitcaseConveyor {
    private ArrayList <Suitcase> conveySuitcase;
    private Log log;
    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();
    
    public SuitcaseConveyor(Log log){
        this.conveySuitcase = new ArrayList <>();
        this.log = log;
    }

    public void depositSuitcase(Suitcase suitcase) throws InterruptedException{
        
        try{
            this.lock.lock();
            while(this.isConveyorFull()){
                full.await();
            }
            if(!this.isConveyorFull()){
                this.conveySuitcase.add(suitcase);
                empty.signal();
                
                this.log.addConveyorEvent("Suitcase: " + suitcase.getSuitcaseID()
                                            + " has been deposited");
            }
        }finally{
            this.lock.unlock();
        }
        
    }
    
    public Suitcase getSuitcase() throws InterruptedException{
        Suitcase toReturnSuitcase = null;
        try{
            this.lock.lock();
            while(this.isConveyorEmpty()){
                empty.await();
            }
            if(!this.isConveyorFull()){
                toReturnSuitcase =  this.conveySuitcase.remove(0);
                full.signal();
                
                this.log.addConveyorEvent("Suitcase: " + 
                                            toReturnSuitcase.getSuitcaseID() + 
                                            " has been gated");
            }
        }finally{
            this.lock.unlock();
        }
        return toReturnSuitcase;
    }
    
    public boolean isConveyorFull(){
        return (this.conveySuitcase.size() == 8);
    }
    
    public boolean isConveyorEmpty(){
        return this.conveySuitcase.isEmpty();
    }
    
}
