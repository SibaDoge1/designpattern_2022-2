package com.holub.ui;

import com.holub.life.RuleManager;

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
			speedlogcaller.setCurrentVal(0);
			populationlogcaller = new PopulationLogCaller("population : ");
	        rulelogcaller = new RuleLogCaller("Current Rule : ");
	        rulelogcaller.setCurrentVal("B3/S23/2");
	        LogPanel.PostRefreshLog();
		}
	}
	
	public static <T> void SetLogValSpeed(T val,T val2) 
	{
		instance.speedlogcaller.resetVal();
		instance.speedlogcaller.setCurrentVal(val);
		instance.speedlogcaller.setCurrentVal(val2);

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
	public static void SetLogValRule() 
	{
		instance.rulelogcaller.setCurrentVal(RuleManager.instance().getRule().getRuleName());
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
