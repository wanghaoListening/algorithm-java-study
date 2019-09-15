package com.haothink.jzoffer;

import java.util.Arrays;

/**
 * @author wanghao
 * @date 2019年09月15日 16:17
 * description: 扑克牌顺子
 *
 * 题目描述：
 * 五张牌，其中大小鬼为癞子（值为0）。判断这五张牌是否能组成顺子。可以使用大小鬼代替任意数值来填充不连续的位置
 *
 * 解题思路：
 * 首先将数组进行排序，则癞子会被排到前面，从数组的第一个不为0的数字开始向后遍历前值+1是否等于后面的值，如果不是则用癞子代替，依次向后遍历，当发现
 * 不连续的位置而此时癞子已经被填充用完，则数组不能成为扑克牌顺子
 *
 *
 */
public class PokerShunzi {


    public static void main(String[] args) {

        System.out.println(isContinuous(new int[]{3,0,1,5,4}));

    }


    private static boolean isContinuous(int[] nums) {

        if(null == nums || nums.length<5){
            return false;
        }
        Arrays.sort(nums);
        int leperCount = 0;
        int preNum = 0;
        for(int num:nums){

            if(0 == num){
                leperCount ++;
            }else{

                if(preNum !=0 && num-preNum == 1){
                    continue;
                }

                int spetCount = leperCount - (num - preNum - 1);
                if (spetCount < 0) {
                    return false;
                }
                preNum = num;
                leperCount = spetCount;
            }
        }
        return true;
    }
}
