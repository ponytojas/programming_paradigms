/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas;

/**
 *
 * @author ponytojas
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
