package com.mvdv.paradigmas;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Airplane {
    private Lock airplaneLock = new ReentrantLock();

    private ArrayList<Suitcase> airplaneContent;
    private ArrayList<String> airplanesStrings;
    private Interface gui;

    public Airplane(Interface gui) {
        this.airplaneContent = new ArrayList<>();
        this.airplanesStrings = new ArrayList<>();
        this.gui = gui;
    }

    public void setSuitcase(Suitcase newSuitcase) {

        try {
            this.airplaneLock.lock();
            this.airplaneContent.add(newSuitcase);
            this.gui.addContentToAirplane(newSuitcase.getSuitcaseID());
            this.airplanesStrings.add(newSuitcase.getSuitcaseID());
        } finally {
            this.airplaneLock.unlock();
        }
    }

    
    public ArrayList<String> getAirplaneIDs() {
        return airplanesStrings;
    }
}
