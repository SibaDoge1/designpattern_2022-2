package com.holub.ui;

public class StringLogCaller extends LogCaller {

	String currentString= "" ;

	public StringLogCaller(String val) {
		super(val);
	}

	@Override
	public <T> void setCurrentVal(T val) {
		if(val.getClass().getName() == "java.lang.String") 
		{
			currentString = val.toString();
		}else 
			System.out.print("type wrong");

	}

	@Override
	void setLogCurrentVal() {
		// TODO Auto-generated method stub
		log.append(currentString);

	}

}
