package com.haothink.bjtu;

import java.util.Arrays;

/**
 * Created by wanghao on 2019-12-22
 * mail:wanghaotime@qq.com
 *
 * 合并排序，归并排序
 *
 * 思想：
 * 分治策略
 *
 **/
public class MergeSort {

    public static void main(String[] args) {

        int[] nums = {7,5,6,4};
        conquer(nums);
        System.out.println(Arrays.toString(nums));
    }

    //合并数组,对合并数组过程进行改造，统计逆序对(5,7) (4,6)
    private static void combine(int[] nums,int low,int mid,int high){

        int[] temp = new int[nums.length];
        for(int k=low;k<=high;k++){
            temp[k] = nums[k];
        }
        int i,j,k;
        for(i=mid,j=high,k=high;i>=low&&j>=mid+1;k--){
            if(temp[i] > temp[j]){
                //前一个集合的元素大于后一个集合的元素则出现逆序对
                nums[k] = temp[i];
                i--;
            }else{
                nums[k] = temp[j];
                j--;
            }
        }

        while(i>=low){nums[k--]=temp[i--];}
        while(j>=mid+1){nums[k--]=temp[j--];}

    }
    //分割数组
    private static void divide(int[] nums,int low,int high){

        if(low < high){
            int mid = (low+high)/2;
            divide(nums,low,mid);
            divide(nums,mid+1,high);
            combine(nums,low,mid,high);
        }
    }
    private static void conquer(int[] nums){

        int low = 0;
        int high = nums.length-1;
        divide(nums,low,high);
    }

}
