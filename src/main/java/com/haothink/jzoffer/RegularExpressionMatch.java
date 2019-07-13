package com.haothink.jzoffer;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年07月13日 14:18
 * description: 正则表达式匹配
 *
 * 题目描述：
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * 应该注意到，'.' 是用来当做一个任意字符，而 '*' 是用来重复前面的字符。这两个的作用不同，不能把 '.' 的作用和 '*' 进行类比，
 * 从而把它当成重复前面字符一次。
 *
 */
public class RegularExpressionMatch {


    public static void main(String[] args) {

        String str = "aaa";
        String pattern = "ab*a";
        System.out.println(match(str,pattern));
    }


    /**
     *
     * @param str
     *        字符串
     * @param pattern
     *        模式串
     * @return
     *        返回匹配结果
     */
    private static boolean match(String str,String pattern){

        if(isEmpty(str) || isEmpty(pattern)){
            return false;
        }

        char[] strArray = str.toCharArray();
        char[] patternArray = pattern.toCharArray();

        int strIndex = 0;
        int patternIndex = 0;
        while (strIndex < strArray.length && patternIndex <patternArray.length){

            if((strArray[strIndex] == patternArray[patternIndex] )
                    || (patternArray[patternIndex] == '.')){
                strIndex++;
                patternIndex++;
                continue;
            }
            if(patternArray[patternIndex] != '*'){

                if(patternArray[patternIndex+1] == '*'){
                    patternIndex+=2;
                }else{
                    return false;
                }
            }else{
                if(patternArray[patternIndex-1] != strArray[strIndex-1]){
                    return false;
                }
                char currentChar = strArray[strIndex];
                while (currentChar == strArray[strIndex]){
                    strIndex++;
                }
                patternIndex++;
            }

        }
        //注意这个地方并不是数组的长度patternArray.length-1而是patternArray.length，因为patternIndex多进了一次循环,
        //这个地方也思考了一下有没有可能是patternIndex > patternArray.length的情况，如果有一定是不匹配的。正常的一定会匹配到
        //最后一个索引位置结束
        return (patternIndex == patternArray.length) && (strIndex == strArray.length);
    }

    private static boolean isEmpty(String str){

        return Objects.isNull(str) || "".equals(str) || " ".equals(str);
    }
}
