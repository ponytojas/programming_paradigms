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
    private ArrayList<Suitcase> conveySuitcase;
    private ArrayList<String> suitcasesIDConveyor;
    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    public SuitcaseConveyor() {
        this.conveySuitcase = new ArrayList<>();
    }

    public void depositSuitcase(Suitcase suitcase) throws InterruptedException {
        try {
            this.lock.lock();
            if (this.isConveyorFull()) {
                full.await();
            }
            this.conveySuitcase.add(suitcase);
            this.suitcasesIDConveyor.add(suitcase.getSuitcaseID());
            
            empty.signal();
        } finally {
            this.lock.unlock();
        }
    }

    public Suitcase getSuitcase() throws InterruptedException {
        Suitcase toReturnSuitcase = null;
        try {

            this.lock.lock();
            if (this.isConveyorEmpty()) {
                this.empty.await();
            }

            toReturnSuitcase = this.conveySuitcase.remove(0);
            this.suitcasesIDConveyor.remove(0);
            this.full.signal();

        } finally {
            this.lock.unlock();
        }
        return toReturnSuitcase;
    }

    public boolean isConveyorFull() {
        return (this.conveySuitcase.size() == 8);
    }

    public boolean isConveyorEmpty() {
        return this.conveySuitcase.isEmpty();
    }
    
    
    public ArrayList<String> getConveyorIDs() {
         
        return suitcasesIDConveyor;

    }

}
