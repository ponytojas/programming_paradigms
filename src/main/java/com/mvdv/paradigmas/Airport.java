/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Airport {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException, InterruptedException {

        int passengerID = 0;
        Log log = new Log();
        SuitcaseConveyor conveyor = new SuitcaseConveyor(log);
        Airplane airplane = new Airplane(log);
        
        
        while(passengerID < 40){
            Passenger passenger = new Passenger(++passengerID, log, conveyor);
            passenger.start();
            log.addPassengerEvent("Created passenger number " + passengerID);
        }
        
        while (employeeID < 2) {
            Employee employee = new Employee(++employeeID, log, conveyor, airplane);
            employees.add(employee);
            employee.start();
            log.addEmployeeEvent("Created employee number " + passengerID);
        }
        
        while (conveyor.getSuitcaseAmount() > 0) {
            Thread.sleep(100);
        
        for (Thread thread: passengers)
            thread.join();
        
        for (Thread thread: employees)
            thread.join();
        

       log.dumpLog();
        
    }
}
