/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Employee extends Thread {

    private final int id;
    private ArrayList<Suitcase> suitcases;
    private SuitcaseConveyor suitcaseConveyor;
    private Airplane airplane;

    public Employee(int id, SuitcaseConveyor suitcaseConveyor, Airplane airplane) {
        this.id = id;
        this.suitcases = new ArrayList<>();
        this.suitcaseConveyor = suitcaseConveyor;
        this.airplane = airplane;
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                this.suitcases.add(this.suitcaseConveyor.getSuitcase());

                try {
                    Thread.sleep((int) (Math.random() * ((70 - 40) + 1)) + 40);
                } catch (InterruptedException ex) {
                }

                this.airplane.setSuitcase(this.suitcases.remove(0));
                
                try {
                    Thread.sleep((int) (Math.random() * ((70 - 40) + 1)) + 40);
                } catch (InterruptedException ex) {
                }

            } catch (InterruptedException ex) {
            }
        }
    }

}
