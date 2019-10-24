package com.mvdv.paradigmas;

import java.util.ArrayList;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */

public class SuitcaseConveyor {
    private ArrayList <Suitcase> conveySuitcase;
    private Log log;
    
    public SuitcaseConveyor(Log log){
        this.conveySuitcase = new ArrayList <>();
        this.log = log;
    }

    public void depositSuitcase(Suitcase suitcase){
        this.conveySuitcase.add(suitcase);
    }
    
    }
    
    public boolean isConveyorFull(){
    }
    
    public boolean isConveyorEmpty(){
        return this.conveySuitcase.isEmpty();
    }
    
}
