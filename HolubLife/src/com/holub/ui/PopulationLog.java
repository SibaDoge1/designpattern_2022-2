package com.holub.ui;

public class PopulationLog implements ILog {
	ProxyLogHanddler handdler;
	
	public void CallLogcall(int val) 
	{
		handdler.SetLogOnAddCount("Population", val);
	}


}
