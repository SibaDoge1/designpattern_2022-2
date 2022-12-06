package com.holub.life.rule;

import com.holub.ui.Colors;

import java.awt.*;
import java.util.Arrays;
import java.util.Map;

public class RuleDefault extends Rule{
    @Override
    protected void init()
    {
        name = "B3/S23/2";
        bornConditions = Arrays.asList(3);
        surviveConditions = Arrays.asList(2,3);
        states = 2;
        stateColors = Map.of(
                0, Colors.LIGHT_YELLOW,
                1, Color.RED
        );
    }
}
