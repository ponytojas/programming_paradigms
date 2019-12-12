/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.client;

import com.mvdv.paradigmas.Airplane;
import com.mvdv.paradigmas.SuitcaseConveyor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


/**
 *
 * @author marks
 */
public class GetInfo extends UnicastRemoteObject implements Interface {
    
    private ArrayList<String> suitcasesIDConveyor;
    private ArrayList<String> suitcasesIDAirplane;
    
    public GetInfo() throws RemoteException{}
    
    
    public ArrayList<String> getAirplaneIDs() throws RemoteException{
        this.suitcasesIDAirplane = Airplane.getAirplaneIDs();
        return suitcasesIDAirplane;
    }
    
    public ArrayList<String> getConveyorIDs() throws RemoteException{
        this.suitcasesIDConveyor = SuitcaseConveyor.getConveyorIDs();
        return suitcasesIDConveyor;
    }
    
    
    
}
