/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Employee(int id, SuitcaseConveyor suitcaseConveyor, Airplane airplane, Log log) {
        this.id = id;
        this.suitcases = new ArrayList<>();
        this.suitcaseConveyor = suitcaseConveyor;
        this.airplane = airplane;
        this.log = log;
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                this.suitcases.add(this.suitcaseConveyor.getSuitcase());
                String textForLog = "The employee " + this.id + " has get a suitcase";
                System.out.println(textForLog);
                this.log.writeToTheLog(textForLog, "Info");
                try {
                    Thread.sleep((int) (Math.random() * ((70 - 40) + 1)) + 40);
                } catch (InterruptedException ex) {
                    String textForError = "There was an error: \n" + ex;
                    this.log.writeToTheLog(textForError, "Error");
                }

                this.airplane.setSuitcase(this.suitcases.remove(0));
                String textForOtherLog = "The employee " + this.id + " has deposit a suitcase";
                System.out.println(textForOtherLog);
                this.log.writeToTheLog(textForOtherLog, "Info");
                
                try {
                    Thread.sleep((int) (Math.random() * ((70 - 40) + 1)) + 40);
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
