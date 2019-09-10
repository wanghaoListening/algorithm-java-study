package com.haothink.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wanghao
 * @date 2019年09月10日 20:09
 * description: 滑动窗口的最大值
 *
 * 题目描述:
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}。
 *
 * 解题思路：
 * 此题逻辑较为简单，设置两个指针分别指向滑动窗口的两边，取滑动窗口的元素的最大值，一直不断向后滑动直到结束。
 *
 */
public class MaxValueInWindow {

    public static void main(String[] args) {

        int[] num = {2,3,4,2,6,2,5,1};
        System.out.println(maxValueInWindows(num,3));
    }


    private static List<Integer> maxValueInWindows(int[] num,int size){

        int startIndex = 0;
        int endIndex = size;

        List<Integer> maxValueList = new ArrayList<>();
        while (endIndex <= num.length){

            int[] window = Arrays.copyOfRange(num,startIndex,endIndex);
            maxValueList.add(selectMaxValue(window));
            startIndex++;
            endIndex++;
        }
        return maxValueList;
    }

    private static int selectMaxValue(int[] num){

        int maxValue = num[0];
        for(int i=1;i<num.length;i++){

            if(num[i] > maxValue){
                maxValue = num[i];
            }
        }
        return maxValue;
    }
}
