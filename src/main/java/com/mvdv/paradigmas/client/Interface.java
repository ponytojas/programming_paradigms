package com.mvdv.paradigmas.client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public interface Interface extends Remote {
    ArrayList<String> getAirplaneIDs() throws RemoteException;
    ArrayList<String> getConveyorIDs() throws RemoteException;
}
