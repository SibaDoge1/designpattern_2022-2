package com.holub.life;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.holub.life.rule.RuleBanners;
import com.holub.life.rule.RuleDefault;
import com.holub.life.rule.RuleManager;

import static com.holub.life.Life.life;
import static org.junit.jupiter.api.Assertions.*;

class RuleManagerTest
{
    @BeforeAll
    static void init(){
        life();
    }

    @DisplayName("setRule을 쓰면 현재 rule이 바뀐다")
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