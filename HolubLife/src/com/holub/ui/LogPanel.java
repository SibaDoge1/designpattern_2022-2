package com.holub.ui;

import java.util.HashSet;
import java.util.HashMap;

import javax.swing.JLabel;

public class LogPanel extends JLabel {
	private static LogPanel instance = null;
	//��ġ�� �ʰ� ����� ���� 
	HashSet<ILogCaller> logCallList = new HashSet<>();
	
	
	public LogPanel() 
	{
		if(instance == null)
			instance=this;
		else
			//�̰��� �α� ���� ���� ��
			return;
	}
	public LogPanel GetInstance () 
	{
		return instance;
	}
	public static void SetLogCallerOnPannel(ILogCaller val) 
	{
		if(instance!=null)
			instance.logCallList.add(val);
		else
			System.out.print("log pannel didn't Setted  ");

	}

	StringBuilder totallog = new StringBuilder();
	public void PostRefreshLog() 
	{
		totallog.setLength(0);
		totallog.append("<html>Log of Life <br>");
		for( ILogCaller logcall : logCallList){
			totallog.append(logcall.GetStoredCommand());
		}
		SetLogPanelText(totallog.toString());
	}

	//�׸��� ���� �α��� ȣ���� �������� 1ƽ�� ���� ������ ȣ��,
	//���� ���� ��������� ����Ͽ� �ۼ��� ��
	public void SetLogPanelText(String val) 
	{
		setText(val);
	}
	
	
	
}
