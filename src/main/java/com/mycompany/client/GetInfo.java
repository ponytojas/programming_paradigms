/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.client;

import com.mvdv.paradigmas.Airplane;
import com.mvdv.paradigmas.Suitcase;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


/**
 *
 * @author marks
 */
public class GetInfo extends UnicastRemoteObject implements Interface {
    
    private ArrayList<Suitcase> airplaneContent;
    public GetInfo() throws RemoteException{}
    
    
    public ArrayList<Suitcase> getAirplaneContent(Airplane airplane) throws RemoteException{
        this.airplaneContent = airplane.getAirplaneContent();
        return airplaneContent;
    }
    
    
    
}
