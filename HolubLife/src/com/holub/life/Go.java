package com.holub.life;

public enum Go {
	Halt		(0, "Halt"), 
	Tick 		(0, "Tick (Single Step)"),
	Agonizing	(500, "Agonizing"),	
	Slow		(150, "Slow"),
	Medium		(70, "Medium"),
	Fast		(50, "Fast");
	
	private final int tick;
	private final String name;
	
	Go(int tick, String name) {
		// TODO Auto-generated constructor stub
		this.tick = tick;
		this.name = name;
	}
	
	public int getTick() {
		return tick;
	}
	
	public String getName() {
		return name;
	}
	
}