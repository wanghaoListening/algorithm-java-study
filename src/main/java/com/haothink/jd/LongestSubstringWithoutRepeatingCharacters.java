package com.haothink.jd;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {


    public static void main(String[] args) {

        String s = " ";

        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {


        Map<Character,Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))){
                maxLength = Math.max(maxLength,map.size());
                i = map.get(s.charAt(i));
                map.clear();
            }
            map.put(s.charAt(i),i+1);
        }
        return Math.max(maxLength,map.size());
    }
}
