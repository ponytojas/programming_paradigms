/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ponytojas
 */
public class Log {
    
    private String airplaneLog = "";
    private String passengersLog = "";
    private String employeeLog = "";
    private String conveyorLog = "";

    public Log() {}
   
    public void addAirplaneEvent(String newStuffToAppend){
        this.airplaneLog += newStuffToAppend + "\n";
    }
    
    public void addPassengerEvent(String newStuffToAppend){
        this.passengersLog += newStuffToAppend + "\n";
    }
        
    public void addEmployeeEvent(String newStuffToAppend){
        this.employeeLog += newStuffToAppend + "\n";
    }
    
    public void addConveyorEvent(String newStuffToAppend){
        this.conveyorLog += newStuffToAppend + "\n";
    }
    
    public void dumpLog() throws IOException{
        String finalStringLog = "";
        
        finalStringLog += "/****Airplane Events****/\n" + this.airplaneLog +"\n";
        finalStringLog += "/***Passenger Events***/\n" + this.passengersLog +"\n";
        finalStringLog += "/****Employee Events****/\n" + this.employeeLog +"\n";
        finalStringLog += "/****Conveyor Events****/\n" + this.conveyorLog +"\n";
        
        try (PrintWriter out = new PrintWriter("log.txt")) {
            out.println(finalStringLog);
        }
        
    }
}
