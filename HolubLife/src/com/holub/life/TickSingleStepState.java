package com.holub.life;

public class TickSingleStepState implements TickState {
	
	private TickData TD;
	
	public TickSingleStepState() {
		
	}
	
	public TickSingleStepState(TickData TD) {
		this.TD = TD;
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
		Clock.instance().tick();
		
	}


}
