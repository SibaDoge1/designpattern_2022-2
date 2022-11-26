package com.holub.life;

import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Go {
	
	private TickData TD;
	private ActionEvent e;
	
	private TickState HaltState;
	private TickState TickSingleStepState;
	private TickState AgonizingState;
	private TickState SlowState;
	private TickState MediumState;
	private TickState FastState;
	private TickState CustomState;
	public TickState CurrentState;
	
	private JMenuItem jmi;
	private JTextField jtf;
	
	
	public Go(TickData TD) {
		// TODO Auto-generated constructor stub
		this.TD = TD;
		this.HaltState = new HaltState(TD);
		this.TickSingleStepState = new TickSingleStepState(TD);
		this.AgonizingState = new AgonizingState(TD);
		this.SlowState = new SlowState(TD);
		this.MediumState = new MediumState(TD);
		this.FastState = new FastState(TD);
		this.CustomState = new CustomState(TD, 0);
	}
	
	public void setActionEvent(ActionEvent e) {
		this.e = e;
	}
	
	public void calculateState() {
		
		if (e.getSource().getClass() == JMenuItem.class) {
			
//			System.out.println("this is JMenuItem");
			
			this.jmi = (JMenuItem)e.getSource();
			String name = jmi.getName();
//			System.out.print(name);
			if (name == "Halt") this.CurrentState = HaltState;
			if (name == "Tick (Single Step)") this.CurrentState = TickSingleStepState;
			if (name == "Agonizing") this.CurrentState = AgonizingState;
			if (name == "Slow") this.CurrentState = SlowState;
			if (name == "Medium") this.CurrentState = MediumState;
			if (name == "Fast") this.CurrentState = FastState;
		}
		else if (e.getSource().getClass() == JTextField.class) {
			
//			System.out.println("this is JTextField");
			this.CurrentState = CustomState;
					
			this.jtf = (JTextField)e.getSource();
			String value = jtf.getText();
			try {
				int cval = Integer.parseInt(value);
				((CustomState)CustomState).setCustomVal(cval);
			} catch (NumberFormatException e) {
				
				((CustomState)CustomState).setCustomVal(0);
			}
			
		}
		else {
//			System.out.println("undefined");
			((CustomState)CustomState).setCustomVal(0);
		}
	}

	public void doAction() {
		CurrentState.doAction();
	}
	
	public void performGo(ActionEvent e) {
		setActionEvent(e);
		calculateState();
		doAction();
	}
	
}