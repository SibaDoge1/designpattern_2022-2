package com.holub.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import com.holub.tools.*;
import com.holub.life.Universe;

public final class LogPanel extends JLabel {
	public LogPanel() 
	{
		
	}
	//이걸 어떤 식으로 넣어야 프록시가 적용될까. 
	//여기서는 간단하게 적에게 호출이 가능한 싱글톤을 활용하겠다. 
	//그리고 최종 로깅의 호출을 라이프의 1틱이 끝이 났을때,
	//점을 새로 찍었을때에 기반하여 작성할 것
	public void SetLogPanelText(String val) 
	{
		setText(val);
	}
	
	
	
}
