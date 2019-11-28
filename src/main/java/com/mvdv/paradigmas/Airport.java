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

        ArrayList<Employee> employees = creator.createEmployees(2, conveyor, airplane);
        ArrayList<Passenger> passengers = creator.createPassenger(40, conveyor);

        for (Employee employee : employees)
            employee.start();

        for (Passenger passenger : passengers)
            passenger.start();

        for (Passenger passenger : passengers)
            passenger.join();

        for (Employee employee : employees)
            employee.join();
    }
}
