package com.haothink.kuaishou;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0){
            
            return 0;
        }
        Set<Integer> sets = new HashSet<>();
        for (int num:nums) {
            sets.add(num);
        }

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {

            if(!sets.contains(nums[i]-1)){
                int val = nums[i];
                int length = 0;
                while (sets.contains(val)){
                    length ++;
                    val ++;
                }
                maxLength = Math.max(length,maxLength);
            }
        }

        return maxLength;
    }
}
