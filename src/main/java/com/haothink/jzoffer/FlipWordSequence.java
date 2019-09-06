package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年09月06日 18:57
 * description: 翻转单词顺序列
 *
 * 题目描述：
 * Input:
 * "I love china."
 *
 * Output:
 * "student. love I"
 *
 * 解题思路：
 *
 *
 */
public class FlipWordSequence {


    public static void main(String[] args) {

        System.out.println(reverseSequence("I love china."));
    }

    private static String reverseSequence(String str){

        if(str.trim().length() == 0) {
            return str;
        }
        String [] temp = str.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = temp.length - 1; i >= 0; i--){
            stringBuilder.append(temp[i]);
            if(i != 0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
