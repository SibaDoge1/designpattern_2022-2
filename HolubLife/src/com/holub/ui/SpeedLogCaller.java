package com.holub.ui;

public class SpeedLogCaller extends NumericalLogCaller {


	public SpeedLogCaller(String val) {
		super(val);
		resetVal();
		LogPanel.PostRefreshLog();

	}



}
