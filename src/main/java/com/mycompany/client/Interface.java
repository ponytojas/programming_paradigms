/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.client;

import com.mvdv.paradigmas.Airplane;
import com.mvdv.paradigmas.Suitcase;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author marks
 */
public interface Interface extends Remote {
    
    //void write(String msg, int IDJpanel) throws RemoteException;
    ArrayList<Suitcase> getAirplaneContent() throws RemoteException;
    
}
