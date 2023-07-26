package com.haothink.didi;

public class FindLackNum {


    public static void main(String[] args) {

        int[] nums = {1,2,4,5,6};

        int lackNum = binarySearchLackNum(nums);
        System.out.println(lackNum);
    }


    public static int findLackNum(int[] nums){

        //find lack num
        if (nums == null || nums.length == 0){

            return -1;
        }
        int base = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (base != nums[i]){
                return base;
            }
            base ++;
        }
        return -1;
    }

    // 1 2 3 5 6 7 8
    public static int binarySearchLackNum(int[] nums){

        int startIndex = 0;
        int endIndex = nums.length-1;

        int baseNum = nums[0];

        while (startIndex < endIndex){

            int midIndex = (startIndex + endIndex)/2;
            int midNum = baseNum + midIndex;
            if (nums[midIndex] > midNum){
                endIndex = midIndex;
            }else if (nums[midIndex] == midNum){
                startIndex = midIndex+1;
            }
        }
        return baseNum + startIndex;
    }
}
