package com.haothink.jzoffer;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年07月13日 15:34
 * description: 表示数值的字符串
 *
 * true:
 * "+100"
 * "5e2"
 * "-123"
 * "3.1416"
 * "-1E-16"
 *
 *
 * false:
 * "12e"
 * "1a3.14"
 * "1.2.3"
 * "+-5"
 * "12e+4.3"
 *
 * 参考：
 * https://zhuanlan.zhihu.com/p/41347029
 *
 *
 * 解题思路
 * 设置三个标志符分别记录“+/-”、“e/E”和“.”是否出现过。
 *
 * 对于“+/-”： 正常来看它们第一次出现的话应该出现在字符串的第一个位置，如果它第一次出现在不是字符串首位，而且它的前面也不是“e/E”，那就不符合规则；
 * 如果是第二次出现，那么它就应该出现在“e/E”的后面，如果“+/-”的前面不是“e/E”，那也不符合规则。
 * 对于“e/E”： 如果它的后面不接任何数字，就不符合规则；如果出现多个“e/E”也不符合规则。
 * 对于“.”： 出现多个“.”是不符合规则的。还有“e/E”的字符串出现“.”也是不符合规则的。 同时，要保证其他字符均为 0-9 之间的数字。
 */
public class StrNumeric {


    public static void main(String[] args) {

        System.out.println(isNumeric("12e+4.3"));
    }


    private static boolean isNumeric(String strNumeric){

        if(isEmpty(strNumeric)){
            return false;
        }

        char[] chArray = strNumeric.toCharArray();
        int numberOfE = 0;
        int numberOfDot = 0;

        for(int i=0;i<chArray.length;i++){

            char ch = chArray[i];

            if(ch == '+' || ch == '-'){

                if(0 == i){
                    continue;
                }
                if(chArray[i-1] == 'e' || chArray[i-1] == 'E'){
                    continue;
                }
                return false;
            }else if(ch == 'e' || ch == 'E'){
                numberOfE ++;

                if(0 == i){
                    return false;
                }
                if(numberOfE > 1){
                    return false;
                }
                if(numberOfDot >=1){
                    return false;
                }
                if(i >= chArray.length-1){
                    return false;
                }
                if(!isNumber(chArray[i+1]) && (!(chArray[i+1] == '-' || chArray[i+1] == '+'))){
                    return false;
                }

            }else if(ch == '.'){
                numberOfDot ++;
                if(0 == i){
                    return false;
                }
                if(numberOfDot >1){
                    return false;
                }

                if(numberOfE >=1){
                    return false;
                }

            }else{
                if(!isNumber(chArray[i])){
                    return false;
                }
            }

        }


        return true;
    }

    public boolean isNumeric2(String str) {

        if(isEmpty(str)){
            return false;
        }

        return str.matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    private static boolean isEmpty(String str){

        return Objects.isNull(str) || "".equals(str) || " ".equals(str);
    }

    private static boolean isNumber(char ch){
        int num = Character.getNumericValue(ch);
        return num >=0 && num <=9;
    }
}
