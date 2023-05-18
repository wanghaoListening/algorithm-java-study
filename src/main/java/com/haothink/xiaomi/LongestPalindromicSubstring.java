package com.haothink.xiaomi;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 中心扩展算法，我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开
 *
 *
 *
 */
public class LongestPalindromicSubstring {

    public String longestPalindromicSubstring(String str){

        char[] chs = str.toCharArray();
        int start = 0,end = 0;
        for (int i=0;i<chs.length;i++){

            int len1 = maxPalindromicLength(chs,i,i);
            int len2 = maxPalindromicLength(chs,i,i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    public int maxPalindromicLength(char[] chs,int startIndex,int endIndex){
        while (startIndex < endIndex && endIndex <= chs.length-1){

            if (chs[startIndex] != chs[endIndex]){
                break;
            }else {
                startIndex++;
                endIndex--;
            }
        }
        return endIndex-startIndex;
    }
}
