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
 * 2.利用归并排序的思想，这里主要是对归并排序合并两个集合的过程进行改造，合并过程中我们对两个集合之间的逆序对进行统计并进行排序，例如
 * 对(5,7) (4,6)两个集合进行合并过程中，分别设置两个指针i,j分别指向两个集合的最大元素，第一个集合的最大元素7大于第二个集合的最大元素6，
 * 则出现的逆序对数为2，将7放入临时数组中，然后前一个集合的指针i向前移动一位，这时5小于6，则第二个集合的指针向前移动一位，发现前一个集合的
 * 5大于后一个集合的4则出现逆序对，不断对集合合并过程的逆序对进行统计则最终集合合并完成的逆序对数量即为所求。
 *
 */
public class InversePairsInArray {

    private static int counter = 0;

    public static void main(String[] args) {

        int[] nums = {7,5,6,4};

        getInversePairs2(nums);
        System.out.println(counter);
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



    //合并数组,对合并数组过程进行改造，统计逆序对(5,7) (4,6)
    private static void merge(int[] nums,int low,int mid,int high){

        int[] temp = new int[nums.length];
        for(int k=low;k<=high;k++){
            temp[k] = nums[k];
        }
        int i,j,k;
        for(i=mid,j=high,k=high;i>=low&&j>=mid+1;k--){
            if(temp[i] > temp[j]){
                //前一个集合的元素大于后一个集合的元素则出现逆序对
                counter+=(j-mid);
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
    private static void mergeSort(int[] nums,int low,int high){

        if(low < high){
            int mid = (low+high)/2;
            mergeSort(nums,low,mid);
            mergeSort(nums,mid+1,high);
            merge(nums,low,mid,high);
        }
    }

    private static void getInversePairs2(int[] nums){

       int low = 0;
       int high = nums.length-1;
       mergeSort(nums,low,high);
    }


}
