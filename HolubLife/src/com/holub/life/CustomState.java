package com.holub.life;

public class CustomState implements TickState {
	
	private TickData TD;
	private int customVal;
	
	public CustomState() {
		
	}
	
	public CustomState(TickData TD, int customVal) {
		this.TD = TD;
		this.customVal = customVal;
	}
	
	@Override
	public void setTick() {
		// TODO Auto-generated method stub
		TD.setTick(customVal);
		
	}

	@Override
	public void startTick() {
		// TODO Auto-generated method stub
		Clock.instance().startTicking();
		
	}


}
