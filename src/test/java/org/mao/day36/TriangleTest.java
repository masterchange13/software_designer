package org.mao.day36;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    Triangle triangle;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        triangle = new Triangle();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void isTri() {
        Assert.assertEquals("一般三角形", new Triangle().IsTri(3, 2, 4));
        Assert.assertEquals("一般三角形", new Triangle().IsTri(3, 4, 4));
        Assert.assertEquals("一般三角形", new Triangle().IsTri(3, 5, 4));
        Assert.assertEquals("一般三角形", new Triangle().IsTri(3, 1, 4));
    }

    @Test
    void isTri2() {
        Assert.assertEquals("一般三角形", new Triangle().IsTri(3, 2, 4));
        Assert.assertEquals("等腰三角形", new Triangle().IsTri(3, 4, 4));
        Assert.assertEquals("一般三角形", new Triangle().IsTri(3, 5, 4));
        Assert.assertEquals("不能构成三角形", new Triangle().IsTri(3, 1, 4));
    }

//    @Test
    @ParameterizedTest
    @ValueSource(strings = {"一般三角形", "等腰三角形", "一般三角形", "不能构成三角形"})
    public void isTri3(String expected) {
        System.out.println(expected);
    }

    @ParameterizedTest
    @CsvSource({"'1', '1', '1'", "'2', '2', '2'", "'13', '4', '2'"})
    public void isTri4(int  a, int b, int c) {
        System.out.println("a------" + a);
        System.out.println("b------" + b);
        System.out.println("c------" + c);
    }


}