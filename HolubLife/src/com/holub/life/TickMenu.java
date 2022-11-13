package com.holub.life;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import com.holub.ui.MenuSite;

public class TickMenu implements Observer {
	private int tick;
	private Object requester;
	private ActionListener modifier;
	
	public TickMenu(Object requester, ActionListener modifier) {
		this.requester = requester;
		this.modifier = modifier;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof TickData) {
			TickData tD = (TickData)o;
			tick = tD.getTick();
			setTickMenu(requester, modifier);
		}
	}
	
	// 여기여기
	public void setTickMenu(Object requester, ActionListener modifier) {
		MenuSite.removeMyMenus(this);
		
	}
}
