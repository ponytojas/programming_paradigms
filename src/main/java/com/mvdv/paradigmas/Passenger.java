package com.mvdv.paradigmas;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Passenger extends Thread{
    
    private final String passengerID;
    private ArrayList <Suitcase> passengerSuitcases;
    private Log log;
    private SuitcaseConveyor suitcaseConveyor;

    public Passenger(int ID, Log log, SuitcaseConveyor suitcaseConveyor) {
        this.passengerID = "Pasajero" +  String.valueOf(ID);
        this.passengerSuitcases = new ArrayList<>();
        this.passengerSuitcases.add(new Suitcase(ID, 1));
        this.passengerSuitcases.add(new Suitcase(ID, 2));
        this.log = log;
        this.suitcaseConveyor = suitcaseConveyor;
    }

    public String getPassengerID() {
        return passengerID;
    }
    
    public boolean hasSuitcase(){
        return this.passengerSuitcases.isEmpty();
    }
    
    @Override
    public void run(){
        while(!this.passengerSuitcases.isEmpty()){
            try {
                this.suitcaseConveyor.
                        depositSuitcase(this.passengerSuitcases.remove(0));
            } catch (InterruptedException ex) {
                Logger.getLogger(Passenger.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

            if(this.passengerSuitcases.isEmpty())
                this.log.addPassengerEvent("No more suitcases for passenger " 
                                            + this.passengerID);
            else
                this.log.addPassengerEvent("Still one suitcase for passenger " 
                                            + this.passengerID);
        }
        
        System.out.println("See you later Aligator: " + this.passengerID);
    }
}
