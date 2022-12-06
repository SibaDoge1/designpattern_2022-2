package com.holub.life.clock;

import java.awt.event.ActionEvent;

public class FastState implements TickState {
	
	private TickData TD;
	
	public FastState() {
		
	}
	
	public FastState(TickData TD) {
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
		TD.setTick(50);
		
	}

	@Override
	public void startTick() {
		// TODO Auto-generated method stub
		Clock.instance().startTicking();
		
	}



}
