package com.haothink.bytedance;

/**
 * Created by wanghao on 2021/9/9
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some
 * characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 * 是子序列，不是子串，所以字符并不需要相连，但是字符顺序还是需要保持的。
 * 用动态规划 Dynamic Programing 来做，使用一个二维数组 dp，其中 dp[i][j] 表示 text1 的前i个字符和 text2
 * 的前j个字符的最长相同的子序列的字符个数
 * 状态转移方程：如何来更新 dp[i][j]，若二者对应位置的字符相同，表示当前的 LCS 又增加了一位，所以可以用 dp[i-1][j-1] + 1 来更新 dp[i][j]。
 *
 **/
public class LongestCommonSubsequence {

  public int longestCommonSubsequence(String text1, String text2) {

    if(text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0){
      return 0;
    }
    int m = text1.length(), n = text2.length();
    char[] chs1 = text1.toCharArray();
    char[] chs2 = text2.toCharArray();
    int[][] dp = new int[m+1][n+1];
    for (int i = 1; i <= m; ++i) {
      for (int j = 1; j <= n; ++j) {
        if (chs1[i-1] == chs2[j-1]) {
          dp[i][j] = dp[i-1][j-1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    return dp[m][n];
  }

  public void dfs(char[] chs1,char[] chs2){

    
  }
}
