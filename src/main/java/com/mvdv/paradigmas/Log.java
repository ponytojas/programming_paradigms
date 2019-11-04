/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.Timestamp;

/**
 *
* @author Marcos Vicente && Daniel Villalobos
 */
public class Log {

    private String airplaneLog = "";
    private String passengersLog = "";
    private String employeeLog = "";
    private String conveyorLog = "";

    public Log() {
    }

    public void addAirplaneEvent(String newStuffToAppend) {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        System.out.println("I/   " + ts + " -- " + newStuffToAppend);
        this.airplaneLog += ts + " -- " + newStuffToAppend + "\n";
    }

    public void addPassengerEvent(String newStuffToAppend) {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        System.out.println("I/   " + ts + " -- " + newStuffToAppend);
        this.passengersLog += ts + " -- " + newStuffToAppend + "\n";
    }

    public void addEmployeeEvent(String newStuffToAppend) {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        System.out.println("I/   " + ts + " -- " + newStuffToAppend);
        this.employeeLog += ts + " -- " + newStuffToAppend + "\n";
    }

    public void addConveyorEvent(String newStuffToAppend) {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        System.out.println("I/   " + ts + " -- " + newStuffToAppend);
        this.conveyorLog += ts + " -- " + newStuffToAppend + "\n";
    }

    public void dumpLog() throws IOException {
        Date date = new Date();
        String finalStringLog = "";

        finalStringLog += "/****Airplane Events****/\n" + this.airplaneLog + "\n";
        finalStringLog += "/***Passenger Events***/\n" + this.passengersLog + "\n";
        finalStringLog += "/****Employee Events****/\n" + this.employeeLog + "\n";
        finalStringLog += "/****Conveyor Events****/\n" + this.conveyorLog + "\n";

        Timestamp ts = new Timestamp(date.getTime());

        try (PrintWriter out = new PrintWriter("log.log")) {
            out.println(finalStringLog);
            System.out.println(ts + " -- Dumping Log into: " + System.getProperty("user.dir"));
        }

    }
}
