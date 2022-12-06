package com.holub.life.clock;

import java.util.Observable;

public class TickData extends Observable {
	private int tick = 0;
	
	public TickData() {}
	
	public void tickChanged() {
		setChanged();
		notifyObservers();
	}
	
	public void setTick(int tick) {
		this.tick = tick;
		tickChanged();
	}
	
	public int getTick() {
		return tick;
	}
}
