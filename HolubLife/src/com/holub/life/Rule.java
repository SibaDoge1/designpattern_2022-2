package com.holub.life;

import java.util.Arrays;
import java.util.List;

public abstract class Rule {
    protected String name;
    protected List bornConditions;
    protected List surviveConditions;
    protected int step;

    public boolean checkState(int neighbor, boolean amAlive) {
        return (bornConditions.contains(neighbor) || (amAlive && surviveConditions.contains(neighbor)));
    }

    public String getRuleName() {
        return name;
    }
}
