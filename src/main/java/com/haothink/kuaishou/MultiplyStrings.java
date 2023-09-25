package com.haothink.kuaishou;


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
        String result = "0";

        long bit = 1;
        for (int i = chs2.length-1; i >= 0; i--) {

            long val = Integer.parseInt(String.valueOf(chs2[i]));
            if (i == chs2.length-1){
                result = addStrings(result,String.valueOf(val*num));
            }else {
                bit = bit*10;
                result = addStrings(result,String.valueOf(val*bit*num));
            }
        }
        return result;
    }

    public String addStrings(String num1, String num2){
        if ("0".equals(num1)){
            return num2;
        }
        if ("0".equals(num2)){
            return num1;
        }

        //维护状态，表示是否需要进位
        int bit = 0;
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        StringBuilder result = new StringBuilder();
        while (index1 >= 0 || index2 >=0){
            char ch1 = index1 >= 0?num1.charAt(index1):'0';
            char ch2 = index2 >= 0?num2.charAt(index2):'0';
            int sum = Integer.parseInt(String.valueOf(ch1)) + Integer.parseInt(String.valueOf(ch2)) + bit;

            bit = sum / 10 > 0?1:0;
            result.append(sum % 10);
            index2 --;
            index1 --;
        }
        if (bit == 1){
            result.append(1);
        }
        return result.reverse().toString();
    }
}
