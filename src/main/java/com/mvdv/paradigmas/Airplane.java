/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas;

import java.util.ArrayList;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Airplane {
    private Log log;
    
    private ArrayList <Suitcase> airplaneContent;
    
    public Airplane(Log log){
        this.airplaneContent = new ArrayList<>();
        this.log = log;
    }
    
    public void setSuitcase(Suitcase newSuitcase){
        this.airplaneContent.add(newSuitcase);
    }
    
}
