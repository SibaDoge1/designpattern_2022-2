package com.holub.life;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;

import com.holub.ui.MenuSite;

public class TickMenu implements Observer {
	private int tick;
	private Object requester;
	private JMenu item;
	
	public TickMenu(Observable observable, Object requester, JMenu item) {
		observable.addObserver(this);
		this.requester = requester;
		this.item = item;
		
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
		
		// the appliance does not show until the window is configured.
		// let the component know that some configuration has occured.
		// tick value를 가져와서 preset인지아닌지.. 확인 가능할듯..
		item.setText(String.valueOf(tick));
		item.repaint();
		
	}

}
