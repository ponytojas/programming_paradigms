package com.mvdv.paradigmas;

import java.util.ArrayList;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Passenger extends Thread {

    private final String passengerID;
    private ArrayList<Suitcase> passengerSuitcases;
    private Log log;
    private SuitcaseConveyor suitcaseConveyor;

    public Passenger(int ID, SuitcaseConveyor suitcaseConveyor, Log log) {
        this.passengerID = "Pasajero" + String.valueOf(ID);
        this.passengerSuitcases = new ArrayList<>();
        this.passengerSuitcases.add(new Suitcase(ID, 1));
        this.passengerSuitcases.add(new Suitcase(ID, 2));
        this.suitcaseConveyor = suitcaseConveyor;
        this.log = log;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public boolean hasSuitcase() {
        return this.passengerSuitcases.isEmpty();
    }

    @Override
    public void run() {
        while (!this.passengerSuitcases.isEmpty()) {
            try {
                this.suitcaseConveyor.depositSuitcase(this.passengerSuitcases.remove(0));
                String textForLog = "The passenger " + this.passengerID + " has deposit the suitcase";
                System.out.println(textForLog);
                this.log.writeToTheLog(textForLog, "Info");
            } catch (InterruptedException ex) {
                String textForError = "There was an error: \n" + ex;
                this.log.writeToTheLog(textForError, "Error");
            }

            try {
                Thread.sleep((int) (Math.random() * ((1000 - 500) + 1)) + 500);
            } catch (InterruptedException ex) {
                String textForError = "There was an error: \n" + ex;
                this.log.writeToTheLog(textForError, "Error");
            }
        }
    }
}
