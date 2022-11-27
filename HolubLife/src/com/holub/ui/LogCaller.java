package com.holub.ui;

import java.util.HashMap;
import java.lang.reflect.Method;

//
public abstract class LogCaller implements ILogCaller{
	protected String logName = "Default Caller : ";
	protected StringBuilder log ;


	public LogCaller(String val) 
	{
		logName = val;
		log = new StringBuilder();
		LogPanel.SetLogCallerOnPannel(this);
		LogPanel.PostRefreshLog();
	}


	//���� ���� �����ϴ� ���.
	public abstract <T> void setCurrentVal(T val);

	
	//��ƽ��Ÿ ��ȣ�� �Ǵ� ��Ȳ���� �αװ� ���� ���� �Ǿ�����. 
	final void getStoredLog() 
	{
		setLogInitalName();
		setLogCurrentVal();
		setLogLineDown();
	}
	public String GetStoredCommand() {
		getStoredLog();
		return log.toString();
	}
	
	void setLogInitalName() 
	{
		log.setLength(0);
		log.append(logName);
	}
	abstract void setLogCurrentVal();
	void setLogLineDown() 
	{
		log.append("<br>");
	}

}

