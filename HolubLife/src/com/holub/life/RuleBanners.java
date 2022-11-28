package com.holub.life;

import com.holub.ui.Colors;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RuleBanners extends Rule{
    @Override
    protected void init()
    {
        name = "B3457/S2367/5";
        bornConditions = Arrays.asList(3,4,5,7);
        surviveConditions = Arrays.asList(2,3,6,7);
        states = 5;
        stateColors = Map.of(
                0, Colors.LIGHT_YELLOW,
                1, Colors.LIGHT_RED,
                2, Colors.GREEN,
                3, Colors.DARK_BLUE,
                4, Colors.MEDIUM_PURPLE
        );
    }
}
