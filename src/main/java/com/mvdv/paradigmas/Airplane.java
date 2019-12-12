/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Airplane {
    private Lock airplaneLock = new ReentrantLock();

    private ArrayList<Suitcase> airplaneContent;

    public Airplane() {
        this.airplaneContent = new ArrayList<>();
    }

    public void setSuitcase(Suitcase newSuitcase) {

        try {
            this.airplaneLock.lock();
            this.airplaneContent.add(newSuitcase);
        } finally {
            this.airplaneLock.unlock();
        }
    }
    //Cambiar para que en vez de un array de maletas nos pase de ese array a otro de strings.
    //public ArrayList<Suitcase> getAirplaneContent() {
        //return airplaneContent;
    //}
    //public ArrayList<String> getAirplaneContent() {
        //Aqui sacamos el ID de las maletas
        
       // return airplaneContent;
    //}
    
    cliente.pintarDatos(ArrayList);

}
