package com.mvdv.paradigmas;

import java.util.ArrayList;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */

public class SuitcaseConveyor {
    private ArrayList <Suitcase> conveySuitcase;
    
    public SuitcaseConveyor(){
        this.conveySuitcase = new ArrayList <>();
    }

    public void depositSuitcase(Suitcase suitcase){
        this.conveySuitcase.add(suitcase);
    }
    
    public Suitcase getSuitcase(){
        return this.conveySuitcase.remove(0);
    }
    
    public boolean isConveyorFull(){
        return (this.conveySuitcase.size() == 7);
    }
    
    public boolean isConveyorEmpty(){
        return this.conveySuitcase.isEmpty();
    }
    
}
