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
    private Log log;
    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();
    private int suitcaseAmount = 80;

    public SuitcaseConveyor(Log log) {
        this.conveySuitcase = new ArrayList<>();
        this.log = log;
    }

    public void depositSuitcase(Suitcase suitcase) throws InterruptedException {

        try {
            this.lock.lock();

            while (this.isConveyorFull()) {
                full.await();
            }
            this.conveySuitcase.add(suitcase);
            empty.signal();
            this.log.addConveyorEvent("Suitcase: " + suitcase.getSuitcaseID() + " has been deposited");
        } finally {
            this.lock.unlock();
        }

    }

    public int getSuitcaseAmount() {
        return this.suitcaseAmount;
    }

    public Suitcase getSuitcase() throws InterruptedException {
        Suitcase toReturnSuitcase = null;
        try {
            this.lock.lock();
            if (this.suitcaseAmount > 0) {

                while (this.isConveyorEmpty()) {

                }
                toReturnSuitcase = this.conveySuitcase.remove(0);
                if (!this.isConveyorFull())
                    full.signal();

                this.suitcaseAmount -= 1;
                System.out.println("Cantidad de maletas: " + this.suitcaseAmount);

                this.log.addConveyorEvent("Suitcase: " + toReturnSuitcase.getSuitcaseID() + " has been gated");
            }
        } finally {
            this.lock.unlock();
        }
        return toReturnSuitcase;
    }

    public boolean isConveyorFull() {
        return (this.conveySuitcase.size() == 8);
    }

    public boolean isConveyorEmpty() {
        return this.conveySuitcase.size() == 0;
    }

    public int getAllSize() {
        return this.conveySuitcase.size();
    }

}
