package com.holub.ui.log;

public class SpeedLogCaller extends LogCaller {

	public SpeedLogCaller(String val) {
		super(val);
		resetVal();
		InitializeOnLog();
	}

	public <T> void setCurrentVal(T val) {
		String temptName = val.getClass().getName();
		if (temptName == "java.lang.String") 
		{
			speedName = val.toString();
		} else 
		{
			String[] words = temptName.split("\\.");
			int wordsLen = words.length;
			if (wordsLen > 1)
				speedName = words[wordsLen - 1];
			else 
				speedName = "error";
		}

	}

	String speedName = "";

	public void resetVal() {
		speedName = "";

	}

	@Override
	void setLogCurrentVal() {
		log.append(speedName);
	}

}
