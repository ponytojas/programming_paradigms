/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Employee extends Thread {

    private final int id;
    private Suitcase suitcase;
    private Log log;
    private SuitcaseConveyor suitcaseConveyor;
    private Airplane airplane;
    private Boolean stillPassengers = true;
    private int amount = 0;

    public Employee(int id, Log log, SuitcaseConveyor suitcaseConveyor, Airplane airplane) {
        this.id = id;
        this.log = log;
        this.suitcase = null;
        this.suitcaseConveyor = suitcaseConveyor;
        this.airplane = airplane;
    }

    public void getSuitcase(Suitcase suitcase) {
        this.suitcase = suitcase;
    }

    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    public void removeSuitcase() {
        this.suitcase = null;
    }

    public void setNoPassengers() {
        this.stillPassengers = false;
    }

    @Override
    public void run(){
        while(this.suitcase == null){
            
            try {
                this.suitcase = this.suitcaseConveyor.getSuitcase();
                
                                this.log.addConveyorEvent("Employee is moving: " + 
                                            this.suitcase.getSuitcaseID());
            } catch (InterruptedException ex) {
                Logger.getLogger(Employee.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
    }

}
