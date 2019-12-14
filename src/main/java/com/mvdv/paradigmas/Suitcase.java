package com.mvdv.paradigmas;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Suitcase {

    private final String suitcaseID;

    public Suitcase(int passengerID, int suitcaseID) {
        this.suitcaseID = "Pasajero" + String.valueOf(passengerID) + "-M" + String.valueOf(suitcaseID);
    }

    public String getSuitcaseID() {
        return suitcaseID;
    }

}
