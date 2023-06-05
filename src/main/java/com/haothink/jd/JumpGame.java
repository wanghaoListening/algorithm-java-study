package com.haothink.jd;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {

    public static void main(String[] args) {

        JumpGame jumpGame = new JumpGame();
        int[] nums = {3,2,1,0,4};
        System.out.println(jumpGame.canJump(nums));
    }

    public boolean canJump(int[] nums) {


        return dfs(nums,0);
    }

    public boolean dfs(int[] nums,int index){

        if (index >= nums.length-1){
            return true;
        }
        int steps = nums[index];
        boolean result = false;
        for (int i = 1; i <= steps; i++) {
            result = result || dfs(nums,index+i);
        }
        return result;
    }

}
