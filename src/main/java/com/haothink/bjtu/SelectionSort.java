package com.haothink.bjtu;

import java.util.Arrays;

/**
 * Created by wanghao on 2019-12-22
 * mail:wanghaotime@qq.com
 * <p>
 * 选择排序
 * <p>
 * 思想：每次都从序列选一个最大的或者最小的元素
 * 分治
 **/
public class SelectionSort {


    public static void main(String[] args) {


        int[] nums = {7, 5, 6, 4,11,2};

        sort(nums, true);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * @param nums      需要排序的数组
     * @param isReverse 是否是逆序
     */
    private static void sort(int[] nums, boolean isReverse) {

        for (int i = 0; i < nums.length; i++) {

            //记录最大元素的下标
            int maxEleIndex = i;
            for (int j = i + 1; j < nums.length - i; j++) {

                if (isReverse) {
                    if (nums[j] > nums[maxEleIndex]) {
                        maxEleIndex = j;
                    }
                } else {
                    if (nums[j] < nums[maxEleIndex]) {
                        maxEleIndex = j;
                    }
                }

            }
            //一轮下来后，交换元素
            int temp = nums[i];
            nums[i] = nums[maxEleIndex];
            nums[maxEleIndex] = temp;

        }

    }
}
