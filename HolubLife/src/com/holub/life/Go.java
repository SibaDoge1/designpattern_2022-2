package com.holub.life;

public enum Go {
	
	//여기여기여기
	// (TODO)
	// enum 을 클래스로 만들어서 state pattern을 적용할 수 있지않을까?
	
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