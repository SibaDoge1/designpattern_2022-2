package com.holub.life.clock;

import java.awt.event.ActionEvent;

public interface TickState {
	
	public void doAction();
	
	public void doAction(ActionEvent e);

	public void setTick();
	
	public void startTick();

	
}
