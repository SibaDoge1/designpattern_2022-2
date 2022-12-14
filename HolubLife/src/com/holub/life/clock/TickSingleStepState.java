package com.holub.life.clock;

import java.awt.event.ActionEvent;

public class TickSingleStepState implements TickState {
	
	private TickData TD;
	
	public TickSingleStepState() {
		
	}
	
	public TickSingleStepState(TickData TD) {
		this.TD = TD;
	}
	
	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		setTick();
		startTick();
		
	}
	
	@Override
	public void doAction(ActionEvent e) {
		// TODO Auto-generated method stub
		doAction();
		
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
