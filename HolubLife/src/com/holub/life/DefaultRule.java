package com.holub.life;

public class DefaultRule implements Rule{
    @Override
    public boolean checkState(int neighbor, boolean amAlive) {
        return (neighbor==3 || (amAlive && neighbor==2));
    }

    @Override
    public String getRuleName() {
        return "B3/S23";
    }
}
