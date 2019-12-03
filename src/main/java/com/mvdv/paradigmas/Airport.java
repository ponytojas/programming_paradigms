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

        Creator creator = new Creator();
        Airplane airplane = new Airplane();
        SuitcaseConveyor conveyor = new SuitcaseConveyor();
        Log log = new Log();
        log.writeToTheLog("Es una prueba", "Info");


        ArrayList<Employee> employees = creator.createEmployees(2, conveyor, airplane);
        ArrayList<Passenger> passengers = creator.createPassenger(40, conveyor);
        
        System.out.println("Pintando cosas para ver que funciona");

        employees.forEach((employee) -> {
            employee.start();
        });

        passengers.forEach((passenger) -> {
            passenger.start();
        });

        for (Passenger passenger : passengers)
            passenger.join();
        
        System.out.println("Oh my god ha terminado");

        for (Employee employee : employees)
            employee.join();
    }
}
