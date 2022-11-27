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
	
	private void setE(ActionEvent e) {
		
		this.e = e;
	}

	private void doAction() {
		
		if (CurrentState instanceof CustomState) {
			JTextField tmp = (JTextField)e.getSource();
			String value = tmp.getText();
			try {
				int cval = Integer.parseInt(value);
				((CustomState)CurrentState).setCustomVal(cval);
			} catch (NumberFormatException e) {
				
				((CustomState)CurrentState).setCustomVal(0);
			}
		}
		
		CurrentState.doAction();
	}
	
	public void performGo(TickState state, ActionEvent e) {
		setState(state);
		setE(e);
		doAction();
	}
	
}