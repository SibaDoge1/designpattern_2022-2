package com.holub.ui;

public class PopulationLogCaller extends NumericalLogCaller {

	private static PopulationLogCaller instance = null;
	public PopulationLogCaller(String val) {
		super(val);
		if(instance ==null)
			instance = this;
	}
	
	public static void setCurrentVal_s(int val) 
	{
		instance.setCurrentVal(val);
	}
	public static void resetVal_s() 
	{
		instance.resetVal();
	}
}
