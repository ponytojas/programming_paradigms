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
    private Log log;
    
    private Lock lock = new ReentrantLock();
    
    private ArrayList <Suitcase> airplaneContent;
    
    public Airplane(Log log){
        this.airplaneContent = new ArrayList<>();
        this.log = log;
    }
    
    public void setSuitcase(Suitcase newSuitcase){
        
         try{
            this.lock.lock();
            this.airplaneContent.add(newSuitcase);
            this.log.addAirplaneEvent("Suitcase: " + newSuitcase.getSuitcaseID()
                                        + " has been stored in the airplane");
            }
        finally{
            this.lock.unlock();
        }
         
    }

}
