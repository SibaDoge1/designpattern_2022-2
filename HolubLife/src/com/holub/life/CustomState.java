package com.holub.life;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

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
	public void doAction() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doAction(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JTextField tmp = (JTextField)e.getSource();
		String value = tmp.getText();
		try {
			int cval = Integer.parseInt(value);
			setCustomVal(cval);
		} catch (NumberFormatException e1) {
			
			setCustomVal(0);
		}
		
		
		setTick();
		startTick();
		
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
	
	public void setCustomVal(int cval) {
		customVal = cval;
	}


}
