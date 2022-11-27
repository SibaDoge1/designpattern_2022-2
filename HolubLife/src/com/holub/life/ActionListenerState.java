package com.holub.life;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerState implements ActionListener{
	
	private TickState state;
	
	public ActionListenerState(TickState state) {
		this.setState(state);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public TickState getState() {
		return state;
	}

	public void setState(TickState state) {
		this.state = state;
	}
	
	

}
