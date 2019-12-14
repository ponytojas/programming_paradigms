/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author marks
 */
public class Client extends Thread {

    public static void main(String[] args) {

        ArrayList<String> arrayAirplane = new ArrayList<>();
        ArrayList<String> arrayConveyor = new ArrayList<>();
        Interface objGetInfo = null;

        while (true) {
            try {
                objGetInfo = (Interface) Naming.lookup("//127.0.0.1/objGetInfo");
            } catch (MalformedURLException | RemoteException | NotBoundException e1) {
                e1.printStackTrace();
            }
            try {
                ArrayList<String> tempAirplane = objGetInfo.getAirplaneIDs();
                ArrayList<String> tempConveyor = objGetInfo.getConveyorIDs();

                if (!arrayAirplane.equals(tempAirplane)) {
                    System.out.println("Ha cambiado en este contenido: ");
                    tempAirplane.removeAll(arrayAirplane);

                    for (String airplaneStuff : tempAirplane)
                        System.out.println(airplaneStuff);

                    arrayAirplane = tempAirplane;
                    tempAirplane = null;
                    
                } else {
                    System.out.println("No ha cambiado nada");
                }
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }
    }
}
