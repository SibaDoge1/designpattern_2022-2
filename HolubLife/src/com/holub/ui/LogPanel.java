package com.holub.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import com.holub.tools.*;
import com.holub.life.Universe;

public final class LogPanel extends JLabel {
	public LogPanel() 
	{
		
	}
	//�̰� � ������ �־�� ���Ͻð� ����ɱ�. 
	//���⼭�� �����ϰ� ������ ȣ���� ������ �̱����� Ȱ���ϰڴ�. 
	//�׸��� ���� �α��� ȣ���� �������� 1ƽ�� ���� ������,
	//���� ���� ��������� ����Ͽ� �ۼ��� ��
	public void SetLogPanelText(String val) 
	{
		setText(val);
	}
	
	
	
}
