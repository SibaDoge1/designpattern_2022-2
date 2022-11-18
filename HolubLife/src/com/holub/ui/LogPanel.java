package com.holub.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import com.holub.life.Universe;

public final class  LogPanel extends JLabel {
	private static	final LogPanel 	theInstance = new LogPanel();
	private LogPanel() 
	{
		setBackground	( Color.white	 );

	}
	//이걸 어떤 식으로 넣어야 프록시가 적용될까. 
	//여기서는 간단하게 적에게 호출이 가능한 싱글톤을 활용하겠다. 
	//그리고 로깅용
	public static void SetLogPanelText(String val) 
	{
		theInstance.setText(val);
	}
	
	public static LogPanel instance()
	{	return theInstance;
	}
	
	
}
