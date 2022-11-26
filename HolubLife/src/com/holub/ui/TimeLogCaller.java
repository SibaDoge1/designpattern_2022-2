package com.holub.ui;

public class TimeLogCaller extends LogCaller {

	public TimeLogCaller() 
	{
		logName = "Passed tick : ";
		log = new StringBuilder();
		LogPanel.SetLogCallerOnPannel(this);

	}

	long passedTick = 0 ;

	@Override
	public <T> void setCurrentVal(T val) {
		if(val.getClass().getName() == "java.lang.Integer") 
		{
			passedTick += (int)val;
		}else 
			System.out.print("speed-type wrong");
	}

	@Override
	void setLogCurrentVal() {
		log.append(passedTick);
	}

}
