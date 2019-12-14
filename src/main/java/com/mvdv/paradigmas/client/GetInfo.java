/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas.client;

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
    private Airplane airplane;
    private SuitcaseConveyor suitcaseConveyor;
    
    public GetInfo(Airplane airplane, SuitcaseConveyor suitcaseConveyor) throws RemoteException{
        this.airplane = airplane;
        this.suitcaseConveyor = suitcaseConveyor;
    }
    
    
    public ArrayList<String> getAirplaneIDs() throws RemoteException{
        this.suitcasesIDAirplane = this.airplane.getAirplaneIDs();
        return suitcasesIDAirplane;
    }
    
    public ArrayList<String> getConveyorIDs() throws RemoteException{
        this.suitcasesIDConveyor = suitcaseConveyor.getConveyorIDs();
        return suitcasesIDConveyor;
    }
    
    
    
}
