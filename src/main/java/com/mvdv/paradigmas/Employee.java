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

    public Employee(int id, SuitcaseConveyor suitcaseConveyor, Airplane airplane, Log log, Stopper stopper) {
        this.id = id;
        this.suitcases = new ArrayList<>();
        this.suitcaseConveyor = suitcaseConveyor;
        this.airplane = airplane;
        this.log = log;
        this.stopper = stopper;
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                this.stopper.checkEmployee(this.id);
                this.suitcases.add(this.suitcaseConveyor.getSuitcase());
                String textForLog = "The employee " + this.id + " has get a suitcase";
                
                //writer.write(textForLog, 2);
                System.out.println(textForLog);
                this.log.writeToTheLog(textForLog, "Info");
                try {
                    Thread.sleep((int) (Math.random() * ((700 - 400) + 1)) + 400);
                } catch (InterruptedException ex) {
                    String textForError = "There was an error: \n" + ex;
                    this.log.writeToTheLog(textForError, "Error");
                }

                this.stopper.checkEmployee(this.id);
                this.airplane.setSuitcase(this.suitcases.remove(0));
                String textForOtherLog = "The employee " + this.id + " has deposit a suitcase";
                System.out.println(textForOtherLog);
                //writer.write(textForLog, 1);
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

    public void pause() {
        try {
            System.out.println("Entrando en la pausa");
            wait();
            System.out.println("Saliendo de la pausa");
        } catch (InterruptedException e) {
        }
    }

}
