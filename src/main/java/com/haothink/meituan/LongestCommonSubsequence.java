package com.haothink.meituan;


//最长公共子串,采用dp
public class LongestCommonSubsequence {


    public int longestCommonSubsequence(String text1, String text2) {

        if (text1== null || text2== null || "".equals(text1) || "".equals(text2)){

            return 0;
        }
        char[] chs1 = text1.toCharArray();
        char[] chs2 = text2.toCharArray();

        int[][] dp = new int[chs1.length+1][chs2.length+1];
        for (int i = 1; i <= chs1.length; i++) {
            for (int j = 1; j <= chs2.length; j++) {

                if (chs1[i-1] == chs2[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[chs1.length][chs2.length];
    }
}
