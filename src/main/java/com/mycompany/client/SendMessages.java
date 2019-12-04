/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author marks
 */
public class SendMessages extends UnicastRemoteObject implements Interface{
    
    public SendMessages() throws RemoteException{};
    
    
    public void write(String msg, int IDJpanel) throws RemoteException{
        System.out.println(msg);
        
    
    }
    
    
}
