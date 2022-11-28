package com.holub.ui;

import java.util.HashSet;
import java.util.HashMap;

import javax.swing.JLabel;

public class LogPanel extends JLabel {
	private static LogPanel instance = null;
	HashSet<ILogCaller> logCallList = new HashSet<>();
	
	
	public LogPanel() 
	{
		if(instance == null)
			instance=this;
		else
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
	public static void PostRefreshLog() 
	{
		instance.totallog.setLength(0);
		instance.totallog.append("<html>Log of Life <br>");
		for( ILogCaller logcall : instance.logCallList){
			instance.totallog.append(logcall.GetStoredCommand());
		}
		instance.SetLogPanelText(instance.totallog.toString());
	}

	//�׸��� ���� �α��� ȣ���� �������� 1ƽ�� ���� ������ ȣ��,
	//���� ���� ��������� ����Ͽ� �ۼ��� ��
	public void SetLogPanelText(String val) 
	{
		setText(val);
	}
	
	
	
}
