package com.haothink.didi;

/**
 *
 *Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 */
public class PalindromicSubstrings {


    public static void main(String[] args) {


        String str = "aaa";

        System.out.println(countSubstrings(str));
    }


    //abacdefd
    public static int countSubstrings(String str){

        int count = 0;

        char[] chs = str.toCharArray();

        for (int i = 0; i < chs.length; i++) {

            count += countHuiWen(chs,i,i);
            count += countHuiWen(chs,i,i+1);
        }
        return count;
    }

    public static int countHuiWen(char[] chs,int startIndex,int endIndex){

        int count = 0;
        while (startIndex >=0 && endIndex <= chs.length-1 && chs[startIndex] == chs[endIndex]){
            count ++;
            startIndex --;
            endIndex ++;
        }
        return count;
    }
}
