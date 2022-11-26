package com.holub.life;

public class HaltState implements TickState {
	
	private TickData TD;
	
	public HaltState() {
		
	}
	
	public HaltState(TickData TD) {
		this.TD = TD;
	}
	
	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		setTick();
		startTick();
		
	}
	
	@Override
	public void setTick() {
		// TODO Auto-generated method stub
		TD.setTick(0);
		
	}

	@Override
	public void startTick() {
		// TODO Auto-generated method stub
		Clock.instance().startTicking();
		
	}


}
