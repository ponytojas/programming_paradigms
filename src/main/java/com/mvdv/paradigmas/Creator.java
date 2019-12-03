package com.mvdv.paradigmas;

import java.util.ArrayList;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Creator {

    public Creator() {
    }

    public ArrayList<Passenger> createPassenger(int amount, SuitcaseConveyor suitcaseConveyor, Log log) {
        ArrayList<Passenger> passengersToReturn = new ArrayList<>();

        for (int index = 0; index < amount; index++)
            passengersToReturn.add(new Passenger(index, suitcaseConveyor, log));
        return passengersToReturn;
    }

    public ArrayList<Passenger> createPassenger(int amount, int previousId, SuitcaseConveyor suitcaseConveyor, Log log) {
        ArrayList<Passenger> passengersToReturn = new ArrayList<>();

        for (int index = 0; index < amount; index++)
            passengersToReturn.add(new Passenger(index + previousId, suitcaseConveyor, log));
        return passengersToReturn;
    }

    public ArrayList<Employee> createEmployees(int amount, SuitcaseConveyor suitcaseConveyor, Airplane airplane, Log log) {
        ArrayList<Employee> employeessToReturn = new ArrayList<>();

        for (int index = 0; index < amount; index++)
            employeessToReturn.add(new Employee(index, suitcaseConveyor, airplane, log));
        return employeessToReturn;
    }

    public ArrayList<Employee> createEmployees(int amount, int previousId, SuitcaseConveyor suitcaseConveyor,
            Airplane airplane, Log log) {
        ArrayList<Employee> employeessToReturn = new ArrayList<>();

        for (int index = 0; index < amount; index++)
            employeessToReturn.add(new Employee(index + previousId, suitcaseConveyor, airplane, log));
        return employeessToReturn;
    }

}
