package com.haothink.jzoffer;


/**
 * @author wanghao
 * @date 2019年08月25日 15:32
 * description: 最长不含重复字符的子字符串
 *
 * 题目描述：
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 *
 * 解题思路：
 *
 */
public class LongestSubstrWithoutDuplicateChar {


    public static void main(String[] args) {

        String str = "arabcacfr";
        System.out.println(getLongestStr(str));

    }

    private static String getLongestStr(String str){
        if(null == str || str.length() == 0){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] chs = str.toCharArray();
        int sum = 0;
        int count = 1;
        stringBuilder.append(chs[0]);
        for(int i=1;i<chs.length;i++){

            if(stringBuilder.indexOf(""+chs[i])==-1){
                count ++;
            }else {
                stringBuilder.delete(0,stringBuilder.length()-1);
                count =1;
            }
            stringBuilder.append(chs[i]);
            if(count > sum){
                sum = count;
            }
        }
        return stringBuilder.toString();

    }
}
