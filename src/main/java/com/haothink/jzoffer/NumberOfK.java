package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年08月31日 19:28
 * description: 数字在排序数组中出现的次数
 *
 * 题目描述：
 *
 * Input:
 * nums = 1, 2, 3, 3, 3, 3, 4, 6
 * K = 3
 *
 * Output:
 * 4
 *
 * 解题思路：
 * 由于数组中的元素是排序的则可以利用二分查找的思想先定位到元素，然后向前向后移动来统计此元素的个数
 */
public class NumberOfK {


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 3, 3, 3, 4, 6};
        System.out.println(binarySearchNumberOfK(nums,3));
    }



    private static int binarySearchNumberOfK(int[] nums,int k){
        int low = 0;
        int high = nums.length-1;
        int middle = (low+high)/2;

        while (low < high){

            if(nums[middle] == k){
                //找到元素位置
                int counter = 1;
                int leftIndex = middle-1;
                int rightIndex = middle+1;
                while(nums[leftIndex] == k){
                    counter++;
                    leftIndex--;
                }
                while(nums[rightIndex] == k){
                    counter++;
                    rightIndex++;
                }
                return counter;
            }else if(nums[middle] > k){
                high = middle-1;
            }else{
                low = middle+1;
            }
            middle = (low+high)/2;
        }
        return 0;
    }
}
