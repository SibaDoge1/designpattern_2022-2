package com.holub.life;

import org.junit.jupiter.api.BeforeAll;	
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.holub.life.Life.life;
import static org.junit.jupiter.api.Assertions.*;

class ActionListenerStateTest
{
    @BeforeAll
    static void init(){
        life();
    }

    @DisplayName("check if ActionListener gets ")
    @Test
    void setRuleTest()
    {
        // given
        RuleBanners ruleBanners = new RuleBanners();

        // when
        RuleManager.instance().setRule(ruleBanners);

        // then
        assertEquals(ruleBanners, RuleManager.instance().getRule());
    }

    @DisplayName("빈 칸의 근처에 2개의 셀이 있으면 checkState는 1을 반환한다")
    @Test
    void checkStateTest()
    {
        // given
        RuleManager.instance().setRule(new RuleDefault());
        RuleBanners ruleBanners = new RuleBanners();
        Resident resident = new Resident();

        // when
        Integer nextState = RuleManager.instance().checkState(resident, 2);

        // then
        assertEquals(0, nextState);
    }

}