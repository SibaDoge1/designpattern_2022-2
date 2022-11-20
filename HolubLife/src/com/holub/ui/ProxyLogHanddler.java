package com.holub.ui;

import java.util.HashMap;

//�α״� ��ɷ� �����Ҳ���? �׳� ��ųʸ��� Ű�� �޾� ������ �ݴ�� �޾ƿü��ְԲ� ����°� ���� �ϰ�ʹ�.
interface ILog
{
	void CallLogcall(int val);
}

// �׷��� �̰� �� ���Ͻ���? �ϴ��� �α� �г��� �ҷ����� ����ٰ� ���� �ִ´� 
// ���ÿ� 
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

