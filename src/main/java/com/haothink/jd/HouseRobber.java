package com.haothink.jd;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security systems connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum
 * amount of money you can rob tonight without alerting the police.
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobber {

    public static void main(String[] args) {

        HouseRobber houseRobber = new HouseRobber();
        int[] nums = {1,2,3,1};
        System.out.println(houseRobber.rob(nums));

    }

    public int rob(int[] nums) {
        return dfs(nums,nums.length-1);
    }

    public int dfs(int[] nums,int houseNum){

        if (houseNum == 0){
            return nums[0];
        }
        if (houseNum == 1){
            return Math.max(nums[0],nums[1]);
        }

        return Math.max(dfs(nums,houseNum-1),dfs(nums,houseNum-2)+nums[houseNum]);
    }

    public int robDp(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (i == 1) {
                // 前两个数特殊处理
                dp[i] = Math.max(dp[i-1], nums[i]);
            } else {
                dp[i] = Math.max(dp[i-1], nums[i] + dp[i - 2]);
            }
        }
        return dp[len - 1];
    }
}
