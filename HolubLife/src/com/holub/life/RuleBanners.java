package com.holub.life;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RuleBanners extends Rule{
    public RuleBanners(){
        name = "B3457/S2367/5";
        bornConditions = Arrays.asList(3,4,5,7);
        surviveConditions = Arrays.asList(2,3,6,7);
        step = 5;
    }
}
