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
    public void run() {
        while (this.stillPassengers) {
            if (!this.suitcaseConveyor.isConveyorEmpty()) {
                try {
                    this.log.addEmployeeEvent("Employer " + this.id + " is trying to get suitcase");
                    Suitcase suitcaseToGet = this.suitcaseConveyor.getSuitcase();
                    if (suitcaseToGet != null) {
                        this.log.addEmployeeEvent("Employer " + this.id + " has gotten the suitcase " + suitcaseToGet.getSuitcaseID());       
                        this.log.addEmployeeEvent("Employer " + this.id + " has gotten " + this.amount + " suitcases");       
                        try {
                            Thread.sleep((int) (Math.random() * ((700 - 400) + 1)) + 400);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.log.addEmployeeEvent("Employer " + this.id + " lefting suitcase on the airplane");
                        this.airplane.setSuitcase(suitcaseToGet);
                        this.log.addEmployeeEvent("Employer " + this.id + " left suitcase on the airplane");
                        try {
                            Thread.sleep((int) (Math.random() * ((700 - 400) + 1)) + 400);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.log.addEmployeeEvent("Employer " + this.id + " returned to get another suitcase");
                    } else {
                        try {
                            Thread.sleep((int) (Math.random() * ((100 - 50) + 1)) + 50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            this.log.addEmployeeEvent("Employer " + this.id + " doesn't find any suitcase to get");
            try {
                Thread.sleep((int) (Math.random() * ((70 - 40) + 1)) + 40);
            } catch (InterruptedException ex) {
                Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
