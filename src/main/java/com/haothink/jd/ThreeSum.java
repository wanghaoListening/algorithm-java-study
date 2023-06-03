package com.haothink.jd;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 */
public class ThreeSum {

    public static void main(String[] args) {

    }


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> listResults = new ArrayList<>();
        Arrays.sort(nums);
        Set<String> duplicateKeys = new HashSet<>();

        int startIndex = 0;
        int endIndex = nums.length-1;
        for(int middleIndex=startIndex+1;middleIndex<endIndex;middleIndex++){

            while (startIndex < endIndex-1 && startIndex <middleIndex){
                int result = nums[startIndex] + nums[middleIndex] + nums[endIndex];
                String duplicateKey = nums[startIndex] + "" + nums[middleIndex] + "" +nums[endIndex];
                if (result == 0 && !duplicateKeys.contains(duplicateKey)){
                    listResults.add(Arrays.asList(nums[startIndex],nums[middleIndex],nums[endIndex]));
                    duplicateKeys.add(duplicateKey);
                }else if (result >0){
                    endIndex --;
                }else if (result <0){
                    startIndex ++;
                }

            }
        }

        return listResults;
    }

}
