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
    
    public static void main(String[] args) throws IOException {
        // Generar los hilos, un consumidor y un productor
        // Primer productor --> Pasajeros
        // Primer consumidor --> Cinta de maletas
        // La cinta a su vez será productor de los empleados
        // Los empleados serán consumidores
        // Necesitamos cerrojo para la cinta de maletas
        // La cinta de maletas tendrá monitor ya que funcionará como un buffer
        /* 
            Los empleados (Consumidores) esperarán (await) hasta que reciban la 
            señal de que hay maletas 
        */
        int passengerID = 0;
        Log log = new Log();
        SuitcaseConveyor conveyor = new SuitcaseConveyor(log);
        
        ArrayList <Passenger> passengers = new ArrayList<>();
        while(passengerID < 40){
            passengers.add(new Passenger(++passengerID, log));
            log.addPassengerEvent("Created passenger number " + passengerID);
        }
        
        log.dumpLog();
    }
}
