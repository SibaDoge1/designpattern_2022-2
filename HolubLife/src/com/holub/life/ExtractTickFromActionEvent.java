package com.holub.life;

import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class ExtractTickFromActionEvent {
	private int tick;
	private JMenuItem jmi;
	private JTextField jtf;
	
	public ExtractTickFromActionEvent() {
		
	}
	
	public ExtractTickFromActionEvent(ActionEvent e) {
		
		// 이렇게하면 JMenuItem인지, JTextField 인지 알 수 있다.
		
		if (e.getSource().getClass() == JMenuItem.class) {
			System.out.println("this is JMenuItem");
			this.jmi = (JMenuItem)e.getSource();
		}
		else if (e.getSource().getClass() == JTextField.class) {
			System.out.println("this is JTextField");
			this.jtf = (JTextField)e.getSource();
		}
		else {
			System.out.println("undefined");
			
		}
	}
	
	public int getTick() {
		return tick;
	}
	
	private void setTick(int tick) {
		this.tick = tick;
	}
}
