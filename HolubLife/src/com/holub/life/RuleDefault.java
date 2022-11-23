package com.holub.life;

import java.util.Arrays;
import java.util.List;

public class RuleDefault extends Rule{
    public RuleDefault(){
        name = "B3/S23/2";
        bornConditions = Arrays.asList(3);
        surviveConditions = Arrays.asList(2,3);
        step = 2;
    }
}
