package com.holub.life;

import java.awt.event.ActionEvent;

public class AgonizingState implements TickState {
	
	private TickData TD;
	
	public AgonizingState() {
		
	}
	
	public AgonizingState(TickData TD) {
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
		TD.setTick(500);
		
	}

	@Override
	public void startTick() {
		// TODO Auto-generated method stub
		Clock.instance().startTicking();
		
	}

	@Override
	public void doAction(ActionEvent e) {
		// TODO Auto-generated method stub
		doAction();
		
	}


}
