package com.haothink.duoduo;

/***
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *  For example,
 *  Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 *  解题思路：
 *  遍历每一列，然后分别求出这一列两边最高的墙。找出较矮的一端，和当前列的高度比较
 */
public class TrappingRainWater {

    public static int trap(int[] height)  {


        int sum = 0;
        for (int i = 1; i < height.length-1; i++) {

            int leftMaxValue = 0;
            for (int j = i-1; j >= 0; j--) {
                if (leftMaxValue < height[j]){
                    leftMaxValue = height[j];
                }
            }

            int rightMaxValue = 0;
            for (int j = i+1; j <= height.length-1; j++) {
                if (rightMaxValue < height[j]){
                    rightMaxValue = height[j];
                }
            }

            //取两边最小值
            int minValue = Math.min(leftMaxValue,rightMaxValue);
            if (minValue > height[i]){
                sum = sum + (minValue - height[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trap(nums);
        System.out.println(result);
    }
}
