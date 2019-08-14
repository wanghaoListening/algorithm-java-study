package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年08月13日 20:30
 * description: 连续子数组的最大和
 *
 * 题目描述：
 * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n)。
 *
 * 例如：
 * {6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 *
 * 解题思路：
 *
 * 可以利用动态规划的办法，用函数f(i)表示以第i个数字结尾的子数组的最大和，而我们需要求出max[f(i)]，其中0<=i<=n。
 * 可以用如下递归公式求f(i)。
 * 如果data[i]=0，就是第一项；
 * 如果f(i-1)<=0,那么就将舍弃前面的子数列，因为加起来会使后面的自数列的值<=自身子数列的值，所以舍弃。
 * 如果f(i-1)>0,则f(i-1)+data[i]会使得以第i个数字结尾的子数组的和更大。
 *
 *
 */
public class MaximumSumOfContinuousSubarray {


    public static void main(String[] args) {

        int[] nums = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(maxSubArray(nums));
    }


    private static int maxSubArray(int[] nums){

        int max = nums[0];
        int sum = nums[0];

        for(int i=1;i<nums.length;i++){

            sum = (sum <= 0)?nums[i]:sum+nums[i];

            if(sum > max){
                max = sum;
            }
        }

        return max;
    }

}
