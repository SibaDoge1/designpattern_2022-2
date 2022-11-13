package com.holub.life;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import com.holub.ui.MenuSite;

public class TickMenu implements Observer {
	private int tick;
	private Object requester;
	private ActionListener modifier;
	
	public TickMenu(Observable observable, Object requester, ActionListener modifier) {
		observable.addObserver(this);
		this.requester = requester;
		this.modifier = modifier;
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof TickData) {
			TickData tD = (TickData)o;
			tick = tD.getTick();
			setTickMenu();
		}
	}
	

	public void setTickMenu() {
		Object requester_tmp = requester;
		ActionListener modifier_tmp = modifier;
		
		MenuSite.removeMyMenus(requester);
//		System.out.println("remove done");
		MenuSite.addLine(requester_tmp,"Go","Halt",  			modifier_tmp);
//		System.out.println("add Line HALT");
		MenuSite.addLine(requester_tmp,"Go","Tick (Single Step)",modifier_tmp);
//		System.out.println("add Line Tick");
		MenuSite.addLine(requester_tmp,"Go","Agonizing",	 	  	modifier_tmp);
//		System.out.println("add Line Agonizing");
		MenuSite.addLine(requester_tmp,"Go","Slow",		 		modifier_tmp);
//		System.out.println("add Line Slow");
		MenuSite.addLine(requester_tmp,"Go","Medium",	 	 	modifier_tmp);
//		System.out.println("add Line Medium");
		MenuSite.addLine(requester_tmp,"Go","Fast",				modifier_tmp);
//		System.out.println("add Line Fast");
		MenuSite.addTextField(requester_tmp,"Tick Rate",				modifier_tmp);
//		System.out.println("add Line TextField");
		MenuSite.addMenu(requester_tmp, String.valueOf(tick));
//		System.out.println("add Line cur");
		
		// the appliance does not show until the window is configured.
		
	}
}
