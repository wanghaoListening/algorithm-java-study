package com.haothink.leetcode.sliding_window;

/**
 * Created by wanghao on 2021-03-10 mail
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LongestSubstringWithoutRepeatingCharacters {


  public static void main(String[] args) {

    String s = "dvdf";

    System.out.println(lengthOfLongestSubstring(s));
  }


  private static int lengthOfLongestSubstring(String str){

    if(null == str || "".equals(str)){

      return 0;
    }else if (str.length() <=1){

      return 1;
    }

    char[] charList = str.toCharArray();
    StringBuilder stringBuilder = new StringBuilder(charList[0]+"");
    int startIndex = 0;
    int endIndex = 1;
    int lengthOfLongestSubstring = 1;

    for(int i=1;i<charList.length;i++){

      if(stringBuilder.indexOf(charList[i]+"") == -1){
        endIndex ++;

      }else {
        stringBuilder = new StringBuilder(stringBuilder.substring(stringBuilder.indexOf(charList[i]+"")+1));
        startIndex = endIndex - stringBuilder.length();
        endIndex++;

      }
      if((endIndex-startIndex) > lengthOfLongestSubstring){
        lengthOfLongestSubstring = (endIndex-startIndex);
      }
      stringBuilder.append(charList[i]+"");
    }
    return lengthOfLongestSubstring;
  }
}
