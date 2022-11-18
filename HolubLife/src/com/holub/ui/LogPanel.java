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
	//�̰� � ������ �־�� ���Ͻð� ����ɱ�. 
	//���⼭�� �����ϰ� ������ ȣ���� ������ �̱����� Ȱ���ϰڴ�. 
	//�׸��� �α��
	public static void SetLogPanelText(String val) 
	{
		theInstance.setText(val);
	}
	
	public static LogPanel instance()
	{	return theInstance;
	}
	
	
}
