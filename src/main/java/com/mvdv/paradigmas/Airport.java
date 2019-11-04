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
 * @author ponytojas
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
        
        Employee employee = new Employee(1, log, conveyor, airplane);
        Employee employee2 = new Employee(2, log, conveyor, airplane);
        
        employee.start();
        employees.add(employee);
        
        employee2.start();
        employees.add(employee2);
        
        for (Thread thread: passengers)
            thread.join();
        
        for (Thread thread: employees)
            thread.join();
        

       log.dumpLog();
        
    }
}
