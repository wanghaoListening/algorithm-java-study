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
 * 1.第一种比较容易想到的方法是逐个元素遍历跟后面的元素进行比较，由于每个数字都要和O(n)个数字作比较，因此这个算法的时间复杂度是O(n^2)
 *
 * 2.利用归并排序的思想，首先将
 *
 */
public class InversePairsInArray {

    private static int counter = 0;

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

    private static void merge(int[] nums,int stepLength){

        if(stepLength >= nums.length){
            return;
        }
        int stepCount = (nums.length%stepLength==0)?nums.length/stepLength:nums.length/stepLength+1;
        int startIndex = 0;
        int endIndex = startIndex+stepLength-1;
        for(int i=1;i<=stepCount;i++){


        }
    }

}
