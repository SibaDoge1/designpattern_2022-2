package com.holub.life;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

public class Go {
	
	private TickData TD;	
	public TickState CurrentState;
	private ActionEvent e;
	
	
	public Go(TickData TD) {
		// TODO Auto-generated constructor stub
		this.TD = TD;
	}
	
	private void setState(TickState state) {
		
		this.CurrentState = state;

	}
	
	private void setActionEvent(ActionEvent e) {
		
		this.e = e;
	}

	private void doAction() {
		
		CurrentState.doAction(e);
	}
	
	public void performGo(TickState state, ActionEvent e) {
		setState(state);
		setActionEvent(e);
		doAction();
	}
	
}