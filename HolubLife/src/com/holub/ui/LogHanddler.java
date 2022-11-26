package com.holub.ui;

import java.util.HashMap;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class LogHanddler implements InvocationHandler{
	private static LogHanddler BaseCarrier ;
	HashMap<String, Integer> postLogDic = new HashMap<>();
	LogPanel thisPanel;
	public LogHanddler(LogPanel panel) 
	{
		thisPanel = panel;
		BaseCarrier= this;
	}
	public LogHanddler GetInstance () 
	{
		return BaseCarrier;
	}
	
	public void CallLogcall(int val) 
	{
		SetLogOnAddCount("Default",val);
	}

	public void SetLogOnAddCount(String key, int value) {
		if(!postLogDic.containsKey(key))
			postLogDic.put(key, value);
		else
			postLogDic.replace(key, postLogDic.get(key) + value);
	}
	public void PostRefreshLog() 
	{
		StringBuilder totallog = new StringBuilder();
		totallog.append("<html>Log of Life <br>");
		for( String key : postLogDic.keySet() ){
			totallog.append(key);
			totallog.append(" : ");
			totallog.append(postLogDic.get(key).toString());
			totallog.append("<br>");
		}
		thisPanel.SetLogPanelText(totallog.toString());
		postLogDic.clear();
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		return null;
	}


}

