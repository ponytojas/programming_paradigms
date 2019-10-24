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
public class Employee extends Thread{
    
    private final int id;
    private Suitcase suitcase;
    private Log log;
    private SuitcaseConveyor conveyor;
    
    public Employee(int id, Log log){
        this.id = id;
        this.log = log;
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
