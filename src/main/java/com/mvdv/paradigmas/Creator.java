package com.mvdv.paradigmas;

import java.util.ArrayList;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Creator {

    public Creator() {
    }

    public ArrayList<Passenger> createPassenger(int amount, SuitcaseConveyor suitcaseConveyor, Log log,
            Stopper stopper) {
        ArrayList<Passenger> passengersToReturn = new ArrayList<>();

        for (int index = 0; index < amount; index++)
            passengersToReturn.add(new Passenger(index, suitcaseConveyor, log, stopper));
        return passengersToReturn;
    }

    public ArrayList<Passenger> createPassenger(int amount, int previousId, SuitcaseConveyor suitcaseConveyor, Log log,
            Stopper stopper) {
        ArrayList<Passenger> passengersToReturn = new ArrayList<>();

        for (int index = 0; index < amount; index++)
            passengersToReturn.add(new Passenger(index + previousId, suitcaseConveyor, log, stopper));
        return passengersToReturn;
    }

    public ArrayList<Employee> createEmployees(int amount, SuitcaseConveyor suitcaseConveyor, Airplane airplane,
            Log log, Stopper stopper) {
        ArrayList<Employee> employeessToReturn = new ArrayList<>();

        for (int index = 0; index < amount; index++)
            employeessToReturn.add(new Employee(index, suitcaseConveyor, airplane, log, stopper));
        return employeessToReturn;
    }

    public ArrayList<Employee> createEmployees(int amount, int previousId, SuitcaseConveyor suitcaseConveyor,
            Airplane airplane, Log log, Stopper stopper) {
        ArrayList<Employee> employeessToReturn = new ArrayList<>();

        for (int index = 0; index < amount; index++)
            employeessToReturn.add(new Employee(index + previousId, suitcaseConveyor, airplane, log, stopper));
        return employeessToReturn;
    }

}
