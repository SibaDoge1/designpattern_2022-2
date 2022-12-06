package com.holub.life;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JMenu;

import org.junit.jupiter.api.Test;

class TickDataUpdateTest {

	@Test
	void test() {

		// given
		TickData TD = new TickData();
		JMenu item = new JMenu(String.valueOf(TD.getTick()));
		TickMenu TM = new TickMenu(TD, this, item);
		
		// when
		TD.setTick(100);
		
		// then
		assertEquals("100", item.getText());
	}

}
