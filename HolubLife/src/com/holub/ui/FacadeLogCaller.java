package com.holub.ui;


public class FacadeLogCaller {
	private static FacadeLogCaller instance = null;
	private TimeLogCaller 	timelogcaller	= null;
	private SpeedLogCaller 	speedlogcaller	= null;
	private PopulationLogCaller populationlogcaller =null;
	private RuleLogCaller rulelogcaller = null; 

	public FacadeLogCaller() 
	{
		if(instance ==null)
		{
			instance= this;
			timelogcaller = new TimeLogCaller("Time : ");
			speedlogcaller = new SpeedLogCaller("Speed type : ");
			speedlogcaller.setCurrentVal("Halt");
			populationlogcaller = new PopulationLogCaller("population : ");
	        rulelogcaller = new RuleLogCaller("Current Rule : ");
	        rulelogcaller.setCurrentVal("B3/S23/2");
	        LogPanel.PostRefreshLog();
		}
	}
	
	public static void SetLogValSpeed(String val) 
	{
		instance.speedlogcaller.setCurrentVal(val);
		LogPanel.PostRefreshLog();	
	}
	public static void SetLogValTime(int val) 
	{
		instance.timelogcaller.setCurrentVal(val);
		LogPanel.PostRefreshLog();	
	}
	
	public static void SetLogValPopulation(int val) 
	{
		instance.populationlogcaller.setCurrentVal(val);
	}
	public static void SetLogValRule(String val) 
	{
		instance.timelogcaller.setCurrentVal(val);
		LogPanel.PostRefreshLog();	
	}
	
	public static void ResetLogValTime() 
	{
		instance.timelogcaller.resetVal();
		LogPanel.PostRefreshLog();	
	}
	
	public static void ResetLogValPopulation() 
	{
		instance.populationlogcaller.resetVal();
		LogPanel.PostRefreshLog();	
	}

}
