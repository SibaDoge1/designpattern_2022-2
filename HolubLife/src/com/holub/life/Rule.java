package com.holub.life;

public interface Rule {
    public boolean checkState(int neighbor, boolean amAlive);
    public String getRuleName();
}
