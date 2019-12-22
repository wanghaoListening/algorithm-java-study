package com.haothink.bjtu;

/**
 * Created by wanghao on 2019-12-22
 * mail:wanghaotime@qq.com
 *
 * 最长公共子序列
 *
 * 我们有两个字符串m和n，如果它们的子串a和b内容相同，则称a和b是m和n的公共子序列。子串中的字符不一定在原字符串中连续。
 *
 * 现在给你两个任意字符串（不包含空格），请帮忙计算它们的最长公共子序列的长度。
 * 注意：子序列≠子串，子序列不是连续的，保持原有相对顺序即可。
 * 如下：
 *
 * 输入: str1 = "abcde", str2 = "ace"
 * 输出: 3
 * 解释: 最长公共子序列是 "ace"，它的长度是 3
 *
 * 最长公共子序列解题思路：
 * 动态规划。
 * dp[i][j]表示str1[0..i]和str2[0..j]
 * 建立一个dp矩阵，是两个字符串一个纵对应，一个横向对应。
 * dp[i][j]表示str1[0…i]和str2[0…j]的最长公共子序列的长度
 *
 * 若str1[i] == str2[j]，则 dp[i][j] = dp[i-1][j-1]+1
 * 若str1[i] != str2[j]，则 dp[i][j] = max( dp[i-1][j], dp[i][j-1] )
 *
 **/
public class LongestCommonSubsequence {


    public static void main(String[] args) {

    }



    private static int findLcs(String str1,String str2){

        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[n][m];

    }
}
