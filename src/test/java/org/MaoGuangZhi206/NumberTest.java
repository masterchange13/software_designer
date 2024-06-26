package org.MaoGuangZhi206;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    void isLeapYear() {
    }

    @Test
    void nextDateCaseDay() {
    }

    Number number;
    private static Set<Integer> MonthWithThirtyDay;

    static {
        MonthWithThirtyDay = Stream.of(4, 6, 9, 11).collect(Collectors.toSet());
    }


    @BeforeEach
    void setup() {
        number = new Number(MonthWithThirtyDay);
    }

    @AfterEach
    void tearDown() {

    }

    @ParameterizedTest
    // 第一个代表期望值；后面的代表你要测试的方法的参数，有几个就写几个
    // 基于语句覆盖测试用例
    @CsvSource({"'20030611', 2003, 06, 10"})
    void nextDateCaseDay(String expected, String year, String month, String day) {
        assertEquals(expected, number.NextDateCaseDay(year, month, day));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/number.csv")
    void nextDateCaseDay2(String expected, String year, String month, String day) {
        assertEquals(expected, number.NextDateCaseDay(year, month, day));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/blackBox.csv")
    void testBlackBox(String expected, String year, String month, String day) {
        assertEquals(expected, number.NextDateCaseDay(year, month, day));
    }

    //     黑盒测试，检查日期是否可以检查错误
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/blackBoxData.csv")
    void testBlackBoxData(String expected, String year, String month, String day) {
        assertEquals(expected, number.NextDateCaseDay(year, month, day));
    }

    //     白盒测试
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/writeBoxData.csv")
    void testWriteBoxData(String expected, String year, String month, String day) {
        assertEquals(expected, number.NextDateCaseDay(year, month, day));
    }

    @ParameterizedTest
    @CsvSource({"'20021030', 2002, 10, 29"})
    void testBirthDay(String expected, String year, String month, String day){
        assertEquals(expected, number.NextDateCaseDay(year, month, day));
    }

//     等价类测试
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/equal.csv")
    void testEqual(String expected, String year, String month, String day) {
        assertEquals(expected, number.NextDateCaseDay(year, month, day));
    }

}