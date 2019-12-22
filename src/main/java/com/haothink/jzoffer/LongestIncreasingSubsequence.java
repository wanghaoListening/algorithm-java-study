package com.haothink.jzoffer;

import java.util.Arrays;

/**
 * Created by wanghao on 2019-12-21
 * mail:wanghaotime@qq.com
 *
 * Given an array of N integer, find the length of the longest increasing subsequence.
 *
 * For example, given [1,-5,4,5,10,-1,-5,7], the longest increasing subsequence is length 4.(1,4,510)
 * 动态规划：
 * 求解nums[0...i]的最长递增子序列的问题可以转换成求解nums[0...i-1]的最长递增子序列的问题
 * 我们将dp[i]表示以a[i]结尾的最长递增子序列的长度
 *
 * 那么在求解dp[i]的时候，就会想到如果nums[i]大于nums[0...i-1]的最长递增子序列的最大元素的话，
 * 那么就将a[i]算进去，如果不是，则看其他子序列有没有最大元素比a[i]小的，将a[i]算到该序列中去。
 *
 * 最长递增子序列
 **/
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        int[] nums = {1,-5,4,5,10,-1,-5,7};

        System.out.println(lengthOfLIS(nums));
        
    }


    private static int lengthOfLIS(int[] nums){

        //初始化所有元素的最长递增子序列的长度为1
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        for(int i=0;i<nums.length;i++){

            int maxEle = 0;
            for(int j=0;j<i;j++){

                //nums[i]大于nums[0...i-1]的最长递增子序列的最大元素
                if(nums[i] > nums[j] && dp[j] + 1 >dp[i]){

                    dp[i] = dp[j]+1;
                }
            }
        }

        return dp[nums.length-1];
    }
}
