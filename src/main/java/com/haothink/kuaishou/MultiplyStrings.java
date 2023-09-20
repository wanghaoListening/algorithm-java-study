package com.haothink.kuaishou;

import java.math.BigInteger;

/**
 * Created by wanghao on 2021/9/25
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the
 * product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *  * 竖式乘法
 *  * 对于例子中的123 * 456，我们可以通过得到:
 *  * 3 * 456 + 20 * 456 + 100 *456 = 1368 + 9120 + 45600 = 56088
 **/
public class MultiplyStrings {

    public static void main(String[] args) {

        MultiplyStrings multiplyStrings = new MultiplyStrings();

        System.out.println(multiplyStrings.multiply("123","456"));
    }

    public String multiply(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }

        long num = Long.parseLong(num1);
        char[] chs2 = num2.toCharArray();
        long result = 0;

        long bit = 1;
        for (int i = chs2.length-1; i >= 0; i--) {

            long val = Integer.parseInt(String.valueOf(chs2[i]));
            if (i == chs2.length-1){
                result += val*num;
            }else {
                bit = bit*10;
                result += val*bit*num;
            }
        }
        return String.valueOf(result);
    }
}
