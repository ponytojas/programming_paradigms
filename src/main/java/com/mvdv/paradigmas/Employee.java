/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas;

/**
 *
 * @author ponytojas
 */
public class Employee {
    
    public final int id;
    public Suitcase suitcase;
    
    public Employee(int id){
        this.id = id;
    }
    
    public void getSuitcase(Suitcase suitcase){
        this.suitcase = suitcase;
    }
    
    public Suitcase getSuitcase(){
        return this.suitcase;
    }
   
    public void removeSuitcase(){
        this.suitcase = null;
    }
}
