package com.holub.life;

import static com.holub.life.Life.life;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.holub.ui.LogPanel;
import com.holub.ui.NumericalLogCaller;
import com.holub.ui.SpeedLogCaller;
import com.holub.ui.UnInitializedLogCaller;

class LogCallerTest {


    @BeforeAll
    static void init(){
        life();
    }

    @DisplayName("Set multiple declaration On Data and Check Only one Code")
    @Test
    void setSpeedTest() 
    {
    	// given

        // when
    	SpeedLogCaller a= new SpeedLogCaller ("Speed2");
    	
        // then
        assertTrue(!LogPanel.IsPanelContainWords("Speed2"));
    }

    @DisplayName("Check UnInitializeCode and get return data")
    @Test   
    void setMaldataTest() 
    {
    	// given
    	UnInitializedLogCaller A = new UnInitializedLogCaller("asd");
        // when
    	
    	
        // then
        assertEquals("No data",LogPanel.GetLogCallerData(A));

    	
    	
    }

    

}
