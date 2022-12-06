package com.holub.life.rule;

import com.holub.life.Resident;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class Rule {
    protected String name;
    protected List bornConditions;
    protected List surviveConditions;
    protected Map<Integer, Color> stateColors;
    protected int states;

    public Rule(){
        init();
    }

    protected abstract void init();

    public Integer checkState(Resident cell, int neighbors) {
        if(cell.getState() == 0){
            if(bornConditions.contains(neighbors))
                return 1;
            else
                return 0;
        }
        else if(cell.getState() == 1){
            if(surviveConditions.contains(neighbors))
                return 1;
            else
                return 2;
        }
        return cell.getState()+1;
    }

    public String getRuleName() {
        return name;
    }

    public int getStates()
    {
        return states;
    }

    public Map<Integer, Color> getStateColors()
    {
        return stateColors;
    }
}
