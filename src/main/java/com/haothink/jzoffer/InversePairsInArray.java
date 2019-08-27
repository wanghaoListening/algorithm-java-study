package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年08月27日 14:48
 * description: 数组中的逆序对
 *
 * 题目描述：
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 例如在数组｛7, 5, 6, 4} 中， 一共存在5 个逆序对，分别是（7, 6）,（7，5）,(7, 4）,（6, 4）和（5, 4）。
 *
 * 解题思路：
 *
 */
public class InversePairsInArray {


    public static void main(String[] args) {

        int[] nums = {7,5,6,4};

        System.out.println(getInversePairs(nums));
    }


    private static int getInversePairs(int[] nums){
        int cur = 0;
        for(int i=0;i<nums.length;i++){

            for(int j=i+1;j<nums.length;j++){

                if(nums[j] < nums[i]){
                    cur++;
                }
            }
        }
        return cur;
    }


    private static int getInversePairs2(int[] nums){

        return 0;
    }
}
