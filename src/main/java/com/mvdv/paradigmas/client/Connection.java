package com.mvdv.paradigmas.client;

import java.util.ArrayList;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Connection extends Thread {
    private ArrayList <String> airplaneContent;
    private ArrayList <String> conveyorContent;
    private ClientInterface clientInterface;

    public Connection(ClientInterface clientInterface){
        this.clientInterface = clientInterface;
    }

    @Override
    public void run() {
        Interface objGetInfo = null;
        airplaneContent = new ArrayList<>();

        while (true) {
            try {
                objGetInfo = (Interface) Naming.lookup("//127.0.0.1/objGetInfo");
            } catch (MalformedURLException | RemoteException | NotBoundException e1) {
            }

            if (objGetInfo != null) {
                try {
                    ArrayList<String> tempAirplane = objGetInfo.getAirplaneIDs();
                    ArrayList<String> tempConveyor = objGetInfo.getConveyorIDs();

                    if (!airplaneContent.equals(tempAirplane)) {
                        System.out.println("Content changed");
                        tempAirplane.removeAll(airplaneContent);
                        airplaneContent.addAll(tempAirplane);
                        
                       this.clientInterface.updateAirplaneContentText(tempAirplane);

                        tempAirplane = null;

                    } else {
                        System.out.println("There's no change");
                    }
                } catch (Exception e) {
                    System.out.println("Error" + e.getMessage());
                }
            }
        }
    }
}