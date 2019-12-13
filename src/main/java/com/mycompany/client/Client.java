/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.client;
import java.rmi.Naming;
import java.util.ArrayList;


/**
 *
 * @author marks
 */
public class Client extends Thread {
        
    public static void main(String[] args){
        while (true){
        try{
            
        
            Interface objGetInfo = (Interface) Naming.lookup("//127.0.0.1/objGetInfo");
         
            
            
            ArrayList<String> arrayAirplane = objGetInfo.getAirplaneIDs();
            ArrayList<String> arrayConveyor = objGetInfo.getConveyorIDs();
            //this.soutAirplane(arrayAirplane);
            for(int i= 0; i<arrayAirplane.size(); i++){
              System.out.println(arrayAirplane.get(i));
            }
          
          }
           // Aqui codigo de la interfaz
            
            

        
        catch (Exception e){
            System.out.println("Error" + e.getMessage());
        }
    }
        
    }  
        //NO SE PORQUE NO VA ESTO:
        //private void soutAirplane(ArrayList<String> arrayAirplane){
            //for(int i= 0; i<arrayAirplane.size(); i++){
              //System.out.println(arrayAirplane.get(i));
        //}
    }
//}
    
    
