package com.haothink.jzoffer;


import java.util.HashMap;
import java.util.Map;

/**
 * @author wanghao
 * @date 2019年08月13日 19:49
 * description: 字符流中第一个不重复的字符
 *
 * 题目描述：
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 *
 * 解题思路：
 *
 * 字符只能一个接着一个从字符流中读出来。可以定义一个数据容器来保存字符在字符流中的位置。当一个字符第一次从字符流中读出来时，把它在字符流中的位置保存到数据容器里。当这个字符再次从
 * 字符流中被读出来时，那么它就
 * 不是只出现一次的字符，也就可以被忽略了。这时把它在数据容器里保存的值更新成一个特殊的值（比如负值）。
 * 为了尽可能高校地解决这个问题，需要在 O(1)时间内往容器里插入一个字符，以及更新一个字符对应的值。这个容器可以用哈希表来实现。用字符的 ASCII 码作为哈希表的键值，而把字符
 * 对应的位置作为哈希表的值。当然如果是使用Java语言那么可以使用LinkedHashMap，他可以保存字符的插入顺序。则Map的value也就不需要记录字符的位置了。
 *
 */
public class FirstNonRepeatingCharacterInStream {

    private static Map<Character,Integer> map = new HashMap<>();


    public static void main(String[] args) {

        String strStream = "google";

        int position = 1;
        for(char ch : strStream.toCharArray()){
            insertChar(ch,position);
            position ++;
        }

        System.out.println(getFirstNonRepeatingCharacter());
    }

    public static void insertChar(char ch,Integer position){

        if(null != map.get(ch)){
            map.remove(ch);
        }else{
            map.put(ch,position);
        }

    }

    public static char getFirstNonRepeatingCharacter(){

        int currentValue = 0;
        char currentChar = ' ';
        for(Map.Entry<Character,Integer> entry : map.entrySet()){

            if(currentValue ==0 ||entry.getValue() < currentValue){
                currentValue = entry.getValue();
                currentChar = entry.getKey();
            }
        }
        return currentChar;
    }

}
