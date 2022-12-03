package com.holub.ui;

public abstract class NumericalLogCaller extends LogCaller{

	public NumericalLogCaller(String val) 
	{
		super(val);
		currentVal = 0;
		InitializeOnLog();
	}

	protected long currentVal = 0;
	public void resetVal() 
	{
		currentVal = 0 ;
	}
	@Override
	public <T> void setCurrentVal(T val) {
		if(val.getClass().getName() == "java.lang.Integer") 
		{
			currentVal += (int)val;
		}else 
			System.out.print("type wrong");
	}

	@Override
	void setLogCurrentVal() {
		log.append(currentVal);
	}

}
