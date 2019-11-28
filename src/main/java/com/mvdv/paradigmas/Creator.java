package com.mvdv.paradigmas;

import java.util.ArrayList;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Creator {

    public Creator() {
    }

    public ArrayList<Passenger> createPassenger(int amount, SuitcaseConveyor suitcaseConveyor) {
        ArrayList<Passenger> passengersToReturn = new ArrayList<>();

        for (int index = 0; index < amount; index++)
            passengersToReturn.add(new Passenger(index, suitcaseConveyor));
        return passengersToReturn;
    }

    public ArrayList<Passenger> createPassenger(int amount, int previousId, SuitcaseConveyor suitcaseConveyor) {
        ArrayList<Passenger> passengersToReturn = new ArrayList<>();

        for (int index = 0; index < amount; index++)
            passengersToReturn.add(new Passenger(index + previousId, suitcaseConveyor));
        return passengersToReturn;
    }

    public ArrayList<Employee> createEmployees(int amount, SuitcaseConveyor suitcaseConveyor, Airplane airplane) {
        ArrayList<Employee> employeessToReturn = new ArrayList<>();

        for (int index = 0; index < amount; index++)
            employeessToReturn.add(new Employee(index, suitcaseConveyor, airplane));
        return employeessToReturn;
    }

    public ArrayList<Employee> createEmployees(int amount, int previousId, SuitcaseConveyor suitcaseConveyor,
            Airplane airplane) {
        ArrayList<Employee> employeessToReturn = new ArrayList<>();

        for (int index = 0; index < amount; index++)
            employeessToReturn.add(new Employee(index + previousId, suitcaseConveyor, airplane));
        return employeessToReturn;
    }

}
