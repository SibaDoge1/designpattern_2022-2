package com.holub.life;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.holub.life.Life.life;
import static org.junit.jupiter.api.Assertions.*;

class RuleDefaultTest
{
    @BeforeAll
    static void init(){
        life();
    }

    @DisplayName("RuleDefault의 이름은 \"B3/S23/2\"이다")
    @Test
    void ruleNameTest()
    {
        // given

        // when
        RuleDefault ruleDefault = new RuleDefault();

        // then
        assertEquals(ruleDefault.getRuleName(), "B3/S23/2");
    }

}