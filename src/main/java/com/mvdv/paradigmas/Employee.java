/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas;

import java.util.ArrayList;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Employee extends Thread {

    private final int id;
    private ArrayList<Suitcase> suitcases;
    private SuitcaseConveyor suitcaseConveyor;
    private Airplane airplane;
    private Log log;
    private Stopper stopper;
    private Interface gui;

    public Employee(int id, SuitcaseConveyor suitcaseConveyor, Airplane airplane, Log log, Stopper stopper, Interface gui) {
        this.id = id;
        this.suitcases = new ArrayList<>();
        this.suitcaseConveyor = suitcaseConveyor;
        this.airplane = airplane;
        this.log = log;
        this.stopper = stopper;
        this.gui = gui;
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                this.stopper.checkGlobal();
                this.stopper.checkEmployee(this.id);
                
                this.suitcases.add(this.suitcaseConveyor.getSuitcase());
                this.gui.updateEmployeeText(this.id, true, this.suitcases.get(0).getSuitcaseID());
                this.gui.updateEmployeeGoBack(this.id, true);
                String textForLog = "The employee " + this.id + " has get a suitcase";
                System.out.println(textForLog);
                this.log.writeToTheLog(textForLog, "Info");
                try {
                    Thread.sleep((int) (Math.random() * ((700 - 400) + 1)) + 400);
                } catch (InterruptedException ex) {
                    String textForError = "There was an error: \n" + ex;
                    this.log.writeToTheLog(textForError, "Error");
                }

                this.stopper.checkGlobal();
                this.stopper.checkEmployee(this.id);
                
                //this.gui.addContentToAirplane(this.suitcases.get(0).getSuitcaseID());
                this.airplane.setSuitcase(this.suitcases.remove(0));
                
                this.gui.updateEmployeeGoBack(this.id, false);
                this.gui.updateEmployeeText(this.id, false, "");
                String textForOtherLog = "The employee " + this.id + " has deposit a suitcase";
                System.out.println(textForOtherLog);
                this.log.writeToTheLog(textForOtherLog, "Info");

                try {
                    Thread.sleep((int) (Math.random() * ((700 - 400) + 1)) + 400);
                } catch (InterruptedException ex) {
                    String textForError = "There was an error: \n" + ex;
                    this.log.writeToTheLog(textForError, "Error");
                }

            } catch (InterruptedException ex) {
                String textForError = "There was an error: \n" + ex;
                this.log.writeToTheLog(textForError, "Error");
            }
        }
    }

}
