package org.mao.day36;

import org.junit.Assert;

public class Triangle {
    String IsTri(int a, int b, int c) {
        if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
            return "不能构成三角形";
        } else {
            if ((a == b) || (b == c) || (a == c)) {
                if ((a == b) && (b == c)) {
                    return "等边三角形";
                } else {
                    return "等腰三角形";
                }
            } else {
                return "一般三角形";
            }
        }
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        int c = 10;

        Assert.assertEquals("等边三角形", new Triangle().IsTri(a, b, c));

        System.out.println(new Triangle().IsTri(a, b, c));
    }
}
