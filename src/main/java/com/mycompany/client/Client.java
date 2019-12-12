/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.client;
import com.mvdv.paradigmas.Airplane;
import java.rmi.Naming;
import com.mvdv.paradigmas.Suitcase;
import java.util.ArrayList;


/**
 *
 * @author marks
 */
public class Client {
        
    public static void main(String[] args){
        try{
            
        
            Interface objGetInfo = (Interface) Naming.lookup("//127.0.0.1/objGetInfo");
         
            //Aqui le pido al servidor que me vaya haciendo:
            
            ArrayList<Suitcase> arrayAirplane = objGetInfo.getAirplaneContent();
            int size = arrayAirplane.size();
            
            for (int i=0; i<size; i++){
                System.out.println(arrayAirplane.get(i));
            }
            
           // escritor.write(msg, IDJpanel)
            
            

        } 
        catch (Exception e){
            System.out.println("Error" + e.getMessage());
        }
    }
    
    
}
