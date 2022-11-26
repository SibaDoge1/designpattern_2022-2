package com.holub.ui;

public class PopulationLogCaller extends LogCaller {

	public PopulationLogCaller()
	{
		logName = "Population : ";
		log = new StringBuilder();
		LogPanel.SetLogCallerOnPannel(this);
		initializePopulation();
	}
	@Override
	public String GetStoredCommand() {
		getStoredLog();
		return null;
	}
	int currentPopulation = 0 ;
	public void initializePopulation() 
	{
		currentPopulation = 0; 
	}

	//add
	@Override
	<T> void setCurrentVal(T val) {
		if(val.getClass().getName() == "java.lang.Integer") 
		{
			currentPopulation += (int)val;
		}else 
			System.out.print("population-type wrong");
	}

	@Override
	void setLogCurrentVal() {
		log.append(currentPopulation);
		
	}

}