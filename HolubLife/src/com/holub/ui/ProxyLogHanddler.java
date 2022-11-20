package com.holub.ui;

import java.util.HashMap;

//로그는 어떤걸로 구성할꺼임? 그냥 딕셔너리에 키값 받아 놓으면 반대로 받아올수있게끔 만드는것 ㄱㄱ 하고싶다.
interface ILog
{
	void CallLogcall(int val);
}

// 그런데 이게 왜 프록시임? 일단은 로그 패널을 불러오되 여기다가 먼저 넣는다 
// 동시에 
public class ProxyLogHanddler implements ILog{
	private static ProxyLogHanddler BaseCarrier ;
	HashMap<String, Integer> postLogDic = new HashMap<>();
	LogPanel thisPanel;
	public ProxyLogHanddler(LogPanel panel) 
	{
		thisPanel = panel;
		BaseCarrier= this;
	}
	public ProxyLogHanddler GetInstance () 
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


}

