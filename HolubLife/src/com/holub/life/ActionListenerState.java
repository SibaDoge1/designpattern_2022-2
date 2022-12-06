package com.holub.life;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.holub.ui.FacadeLogCaller;

public class ActionListenerState implements ActionListener{
	
	private TickState state;
	private Go Go;
	
	public ActionListenerState(TickState state, Go Go) {
		this.setState(state);
		this.setGo(Go);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		actionPerformed(e, this.Go);
		
		FacadeLogCaller.SetLogValSpeed(this.getState());
	}
	
	public void actionPerformed(ActionEvent e, Go Go) {
		
		Go.performGo(this.getState(), e);
		
	}

	public TickState getState() {
		return state;
	}

	public void setState(TickState state) {
		this.state = state;
	}
	
	public Go getGo() {
		return this.Go;
	}
	
	public void setGo(Go Go) {
		this.Go = Go;
	}
	
	

}
