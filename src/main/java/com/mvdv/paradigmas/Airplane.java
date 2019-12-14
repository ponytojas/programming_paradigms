/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private Interface gui;

    public Airplane(Interface gui) {
        this.airplaneContent = new ArrayList<>();
        this.gui = gui;
    private ArrayList<String> suitcasesIDAirplane;
    
    
    public Airplane() {
        this.airplaneContent = new ArrayList<>();
        this.suitcasesIDAirplane = new ArrayList<>();            

    }

    public void setSuitcase(Suitcase newSuitcase) {

        try {
            this.airplaneLock.lock();
            this.airplaneContent.add(newSuitcase);
            this.gui.addContentToAirplane(newSuitcase.getSuitcaseID());
        } finally {
            this.airplaneLock.unlock();
        }
    }

    
    public ArrayList<String> getAirplaneIDs() {
         
        return suitcasesIDAirplane;

    }
}
