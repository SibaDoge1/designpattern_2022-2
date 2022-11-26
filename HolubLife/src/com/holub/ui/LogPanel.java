package com.holub.ui;

import java.util.HashSet;
import java.util.HashMap;

import javax.swing.JLabel;

public class LogPanel extends JLabel {
	private static LogPanel instance = null;
	//겹치기 않게 만들기 위해 
	HashSet<ILogCaller> logCallList = new HashSet<>();
	
	
	public LogPanel() 
	{
		if(instance == null)
			instance=this;
		else
			//이곳에 로그 에러 넣을 것
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

	//그리고 최종 로깅의 호출을 라이프의 1틱이 끝이 났을때 호출,
	//점을 새로 찍었을때에 기반하여 작성할 것
	public void SetLogPanelText(String val) 
	{
		setText(val);
	}
	
	
	
}
