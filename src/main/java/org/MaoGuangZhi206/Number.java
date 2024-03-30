/**
 * @author: mao
 * @description 注解学习
 * @date: 2024/3/20 8:24
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package org.MaoGuangZhi206;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Number {

    private static Set<Integer> MonthWithThirtyDay;
    // 构造有30天的月份集合
//    public static final Set<Integer> MonthWithThirtyDay;
    static {
        MonthWithThirtyDay = Stream.of(4, 6, 9, 11).collect(Collectors.toSet());
    }
    // 构造没有30天的月份集合
    public static final Set<Integer> MonthWithThirtyOneDay;
    static {
        MonthWithThirtyOneDay = Stream.of(1, 3, 5, 7, 8, 10, 12).collect(Collectors.toSet());
    }
//    MonthWithThirtyDay = Stream.of(4, 6, 9, 11).collect(Collectors.toSet());

    public Number(Set<Integer> MonthWithThirtyDay) {
        this.MonthWithThirtyDay = MonthWithThirtyDay;
    }

    // 判断某一年是不是闰年的函数
    public boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            // 是闰年
            return true;
        }
        return false;
    }

    public String NextDateCaseDay(String InYear, String InMonth, String InDay) {
        String verifyMessage = NextDateVerifyPara(InYear, InMonth, InDay);
        if (null != verifyMessage) return verifyMessage;//输入参数有问题，直接返回相应错误信息
        //参数都对，继续
        int year = Integer.parseInt(InYear);
        int month = Integer.parseInt(InMonth);
        int day = Integer.parseInt(InDay);

        if (31 == day) {
            if (12 == month) {
                year++;
                month = 1;
                day = 1;
            } else {
                month++;
                day = 1;
            }
        } else if (30 == day) {
            if (this.MonthWithThirtyDay.contains(month)) {
                day = 1;
                month ++;
            } else day++;
        } else if (28 == day) {
            if (isLeapYear(year)) {// 是闰年
                day = 29;
            } else {
                day = 1;
                month++;
            }
        } else if (day == 29) {
            if (2 == month) {
                day = 1;
                month++;
            } else day++;
        }else {
            day ++;
        }
        //JDK1.8中Stream，JDK1.8 lamada表达式
        //年4位，月2位，日2位，45年1月1日，00450102,00450102，推导"0045"+"01";
        System.out.println("year " + year + " month " + month + " day " + day );
        return Stream.of(String.format("%04d", year), String.format("%02d", month), String.format("%02d", day)).reduce((str, str1) -> str + str1).get();
    }

    private String NextDateVerifyPara(String inYear, String inMonth, String inDay) {
        if (null == inYear || null == inMonth || null == inDay) {
            return "日期参数不能为空";
        }
        return null;
    }
}