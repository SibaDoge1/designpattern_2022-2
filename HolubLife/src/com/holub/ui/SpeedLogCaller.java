package com.holub.ui;

public class SpeedLogCaller extends LogCaller {

	
	int currentSpeed = 0 ;
	public SpeedLogCaller()
	{
		logName = "Speed : ";
		log = new StringBuilder();
		LogPanel.SetLogCallerOnPannel(this);
	}

	@Override
	public String GetStoredCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	<T> void setCurrentVal(T val) {
		// TODO Auto-generated method stub
		if(val.getClass().getName() == "java.lang.Integer") 
		{
			currentSpeed += (int)val;
		}else 
			System.out.print("speed-type wrong");
	}

	@Override
	void setLogCurrentVal() {
		log.append(currentSpeed);
	}

}
