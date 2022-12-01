package com.holub.ui;

public class SpeedLogCaller extends LogCaller {


	public SpeedLogCaller(String val) {
		super(val);
		resetVal();
		LogPanel.PostRefreshLog();

	}
	
	public <T> void setCurrentVal(T val) 
	{
		String temptName = val.getClass().getName() ;
		if (temptName == "java.lang.String")
		{
			speedName = val.toString();
		}else 
		{
			String[] words = temptName.split("\\.");
			int wordsLen = words.length;
			speedName = words[wordsLen-1];
		}

	}
 	String speedName = "" ;
	public void resetVal() 
	{
		speedName = "";

	}

	@Override
	void setLogCurrentVal() {
		log.append(speedName);
	}



}
