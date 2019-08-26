package com.haothink.jzoffer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wanghao
 * @date 2019年08月26日 20:18
 * description: 第一个只出现一次的字符位置
 *
 * 题目描述：
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
 * Input: abacc
 * Output: b
 *
 * 解题思路：
 * 这个题直观反应就是一边遍历字符串的字符一边使用hash表来进行存储，key为字符value为字符出现的次数。当然需要保证hash表插入字符的顺序
 *
 *
 *
 */
public class FirstCharPositionAppearsOnlyOnce {


    public static void main(String[] args) {

        System.out.println(getFirstNotRepeatingChar("caeebacc"));
    }


    public static int getFirstNotRepeatingChar(String str) {
        Map<Character,Integer> map = new LinkedHashMap<>(str.length());

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,-1);
            }else{
                map.put(ch,i);
            }
        }

        int pos = -1;

        for(Integer value:map.values()){
            if(value != -1){
                pos = value;
                break;
            }
        }
        return pos;
    }


}
