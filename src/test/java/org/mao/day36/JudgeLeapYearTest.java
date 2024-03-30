package org.mao.day36;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JudgeLeapYearTest {

    JudgeLeapYear judgeLeapYear;

    @BeforeEach
    void setUp() {
        judgeLeapYear = new JudgeLeapYear();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isLeap() {
        Assert.assertEquals(true, judgeLeapYear.isLeap(2000));
        Assert.assertEquals(true, judgeLeapYear.isLeap(2004));
    }

    @Test
    void isLeap2() {
        Assert.assertEquals(false, judgeLeapYear.isLeap(2001));
        Assert.assertEquals(false, judgeLeapYear.isLeap(2002));
    }


}