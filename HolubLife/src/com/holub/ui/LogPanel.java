package com.holub.ui;

import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;

import javax.swing.JLabel;

public class LogPanel extends JLabel {
	private static LogPanel instance = null;
	HashSet<ILogCaller> logCallList = new HashSet<>();

	public LogPanel() {
		if (instance == null)
			instance = this;
		else
			return;
	}

	public LogPanel GetInstance() {
		return instance;
	}

	public static void SetLogCallerOnPannel(ILogCaller caller) {
		if (instance != null) {
			Iterator<ILogCaller> iter = instance.logCallList.iterator();
			while (iter.hasNext()) {
				var tempt = iter.next();
				if (tempt.getClass().getName() == caller.getClass().getName()) 
				{
					System.out.print("log pannel didn't Setted  ");
					return;
				}
			}
			instance.logCallList.add(caller);
		} else
			System.out.print("log pannel didn't Setted  ");

	}

	StringBuilder totallog = new StringBuilder();

	public static void PostRefreshLog() {
		instance.totallog.setLength(0);
		instance.totallog.append("<html>Log of Life <br>");
		for (ILogCaller logcall : instance.logCallList) {
			instance.totallog.append(logcall.GetStoredCommand());
		}
		instance.SetLogPanelText(instance.totallog.toString());
	}

	// �׸��� ���� �α��� ȣ���� �������� 1ƽ�� ���� ������ ȣ��,
	// ���� ���� ��������� ����Ͽ� �ۼ��� ��
	public void SetLogPanelText(String val) {
		setText(val);
	}

	public static boolean IsPanelContainWords(String val) {

		return instance.totallog.toString().contains(val);
	}

	public static String GetLogCallerData(ILogCaller caller) {

		Iterator<ILogCaller> iter = instance.logCallList.iterator();
		while (iter.hasNext()) {
			var tempt = iter.next();
			if (tempt.getClass().getName() == caller.getClass().getName()) {
				return tempt.GetStoredCommand();
			}
		}
		return "No data";
	}

}
