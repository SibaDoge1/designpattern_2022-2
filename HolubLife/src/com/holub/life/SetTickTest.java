package com.holub.life;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SetTickTest {

    @DisplayName("check if JMenuItemState gets proper value")
    @Test
    void setTickJMenuItemState()
    {
        // given
    	TickData TD = new TickData();
    	Go Go = new Go(TD);
    	HaltState JMenuItemState = new HaltState(TD);

        // when
    	JMenuItemState.setTick();

        // then
        assertEquals(0, TD.getTick());
    }
    
    @DisplayName("check if JTextField gets proper value")
    @Test
    void setTickJTextFieldState()
    {
        // given
    	TickData TD = new TickData();
    	Go Go = new Go(TD);
    	CustomState JTextFieldState = new CustomState(TD,100);

        // when
    	JTextFieldState.setTick();

        // then
    	assertEquals(100, TD.getTick());
    }

}

