package com.haothink.bjtu;

/**
 * Created by wanghao on 2019-12-22
 * mail:wanghaotime@qq.com
 *
 * 快速排序
 *
 * 思想：分治
 *
 **/
public class QuickSort {


    public static void main(String[] args) {

    }



    private static void quickSort(int[] nums,int startIndex,int endIndex){

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

        quickSort(nums,lowIndex,startIndex-1);
        quickSort(nums,startIndex+1,highIndex);

    }
}
