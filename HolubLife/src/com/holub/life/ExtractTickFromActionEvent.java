package com.holub.life;

import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class ExtractTickFromActionEvent {
	private String name;
	private int tick;
	private JMenuItem jmi;
	private JTextField jtf;
	private ActionEvent e;
	
	public ExtractTickFromActionEvent() {
		
	}
	
	public ExtractTickFromActionEvent(ActionEvent e) {
		this.e = e;
		getTickFromActionEvent();
	}
	
	private void getTickFromActionEvent() {
//		이렇게하면 JMenuItem인지, JTextField 인지 알 수 있다.
		if (e.getSource().getClass() == JMenuItem.class) {
			
			System.out.println("this is JMenuItem");
			
			this.jmi = (JMenuItem)e.getSource();
			String name = jmi.getName();
			for (Go gval : Go.values()) {
				if (name.equals(gval.getName())){
					setTick(gval.getTick());
					setName(gval.getName());
				}
			}
		}
		else if (e.getSource().getClass() == JTextField.class) {
			
			System.out.println("this is JTextField");
			
			this.jtf = (JTextField)e.getSource();
			String value = jtf.getText();
			try {
				setTick(Integer.parseInt(value));
				setName("Custom");
			} catch (NumberFormatException e) {
				setTick(0);
				setName("Invalid");
			}
			
		}
		else {
			System.out.println("undefined");
			setTick(0);
			setName("Unknown");
			
		}
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public int getTick() {
		return tick;
	}
	
	private void setTick(int tick) {
		this.tick = tick;
	}
}
