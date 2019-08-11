package com.haothink.jzoffer;

import java.util.Arrays;

/**
 * @author wanghao
 * @date 2019年08月10日 23:20
 * description: 最小的 K 个数
 *
 * 题目描述：
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 *
 * 解题思路：
 * 这道题咋一看有很多方法，各种经典的排序算法都可以实现，比如可以进行冒泡排序进行到第k趟排序即可停止，选择排序，选择最小的元素，也是进行到第k趟选择即可停止，
 * 还有利用小根堆排序的方式，选到第k轮次即可，当然在所有的排序方法当中快速排序的效率最高，我们可不可以利用快排的思想进行实现，我们知道在快排当中当我们以k为
 * 分割值，则k的前边所有元素即为小于k的元素，而k后面的元素即为大于k的元素，所以k以及其前面的元素即为最小的 K 个数。
 *
 */
public class MinKOfNumbers {


    public static void main(String[] args) {

        int[] nums = {4,5,1,6,2,7,3,8};
        quickSort(nums,0,nums.length-1,4);
        System.out.println(Arrays.toString(nums));

    }



    private static void quickSort(int[] nums,int startIndex,int endIndex,int k){

        if(startIndex > endIndex){
            return;
        }

        int shiftNum = nums[startIndex];
        int lowIndex = startIndex,highIndex = endIndex;

        while (startIndex < endIndex){

            while (nums[endIndex] >= shiftNum && startIndex < endIndex){
                endIndex --;
            }
            while (nums[startIndex] <= shiftNum && startIndex < endIndex){
                startIndex ++;
            }
            if(startIndex < endIndex){
                int temp = nums[endIndex];
                nums[endIndex] = nums[startIndex];
                nums[startIndex] = temp;
            }

        }
        //将基准位置的数值放到两个列表中点位置
        nums[lowIndex] = nums[startIndex];
        nums[startIndex] = shiftNum;
        if(k == (startIndex+1)){
            //证明前k个数以及是最小的k个数了,则停止继续快排序
            return;
        }
        quickSort(nums,lowIndex,startIndex-1,k);
        quickSort(nums,startIndex+1,highIndex,k);

    }
}
