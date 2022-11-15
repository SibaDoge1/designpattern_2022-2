package com.holub.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

public final class  LogPanel {
	private static JLabel 		logLabel	= null;	
	public synchronized static void establish(JFrame container)
	{
		logLabel = new JLabel();
		
		
		assert valid();
	}
	
	private static boolean valid()
	{	assert logLabel   != null : "logPanel not established";
		return true;
	}
	
}
