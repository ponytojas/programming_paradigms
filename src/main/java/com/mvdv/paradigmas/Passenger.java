package com.mvdv.paradigmas;

import java.util.ArrayList;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Passenger {
    
    private final String passengerID;
    private ArrayList <Suitcase> passengerSuitcases;
    private Log log;

    public Passenger(int ID, Log log) {
        this.passengerID = "Pasajero" +  String.valueOf(ID);
        this.passengerSuitcases = new ArrayList<>();
        this.passengerSuitcases.add(new Suitcase(ID, 1));
        this.passengerSuitcases.add(new Suitcase(ID, 2));
        this.log = log;
    }

    public String getPassengerID() {
        return passengerID;
    }
    
    public boolean hasSuitcase(){
        return this.passengerSuitcases.isEmpty();
    }
    
}
