package com.holub.ui;

import java.util.HashMap;
import java.lang.reflect.Method;

//
public abstract class LogCaller implements ILogCaller{
	protected String logName = "Default Caller : ";
	protected StringBuilder log ;


	public LogCaller() 
	{
		logName = "Default Caller : ";
		log = new StringBuilder();
	}

	//현재 값을 세팅하는 방식.
	abstract <T> void setCurrentVal(T val);

	
	//매틱마타 재호출 되는 상황에서 로그가 새로 생성 되었을때. 
	final void getStoredLog() 
	{
		setLogInitalName();
		setLogCurrentVal();
		setLogLineDown();
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

