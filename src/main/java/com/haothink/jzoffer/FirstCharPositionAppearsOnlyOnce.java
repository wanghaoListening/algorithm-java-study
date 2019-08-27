package com.haothink.jzoffer;

import java.util.BitSet;
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
 * 这个题直观反应就是一边遍历字符串的字符一边使用hash表来进行存储，key为字符value为字符出现的次数。当然需要保证hash表插入字符的顺序。
 * 考虑到只需要找到出现一次的字符，那么需要统计字符的次数信息只有0,1,或者更大，所以可以使用占用空间更少的bit数组
 *
 *
 *
 */
public class FirstCharPositionAppearsOnlyOnce {


    public static void main(String[] args) {

        System.out.println(getFirstNotRepeatingChar("caeebacc"));

        System.out.println(getFirstNotRepeatingChar2("caeebacc"));
    }


    private static int getFirstNotRepeatingChar(String str) {
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


    private static int getFirstNotRepeatingChar2(String str){
        BitSet oneBit = new BitSet(str.length());
        BitSet twoBit = new BitSet(str.length());

        for(char ch : str.toCharArray()){

            if(!oneBit.get(ch) && !twoBit.get(ch)){
                oneBit.set(ch);
            }else if(oneBit.get(ch) && !twoBit.get(ch)){
                twoBit.set(ch);
            }
        }

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(oneBit.get(ch) && !twoBit.get(ch)){
                return i;
            }

        }
        return -1;

    }



}
