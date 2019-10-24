/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas;

import java.util.ArrayList;

/**
 *
 * @author ponytojas
 */
public class Airplane {
    
    private ArrayList <Suitcase> airplaneContent;
    
    public Airplane(){
        this.airplaneContent = new ArrayList<>();
    }
    
    public void setSuitcase(Suitcase newSuitcase){
        this.airplaneContent.add(newSuitcase);
    }
    
}
