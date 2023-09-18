package com.haothink.meituan;

public class LongestCommonSubstring {

    // https://www.jianshu.com/p/a2cc662c0453


    public static void main(String[] args) {


        LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
        System.out.println(longestCommonSubstring.longestCommonSubsequence("1AB2345CD","12345EF"));
    }


    public String longestCommonSubsequence(String text1, String text2) {

        if (text1== null || text2== null || "".equals(text1) || "".equals(text2)){

            return "";
        }
        char[] chs1 = text1.toCharArray();
        char[] chs2 = text2.toCharArray();

        String maxCommonStr = "";
        int maxLength = 0;
        int m = chs1.length;
        int n = chs2.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chs1[i] == chs2[j]){
                    int length = maxCommonStr(chs1,chs2,i,j);
                    if (length > maxLength) {
                        maxLength = length;
                        maxCommonStr = text1.substring(i,i+length);
                    }
                }
            }
        }
        return maxCommonStr;
    }

    private int maxCommonStr(char[] chs1,char[] chs2,int startIndex1,int startIndex2){

        int length = 0;
        while (startIndex1 < chs1.length && startIndex2 < chs2.length){

            if (chs1[startIndex1] == chs2[startIndex2]){
                length ++;
                startIndex1 ++;
                startIndex2 ++;
            }else {
                break;
            }
        }
        return length;
    }
}
