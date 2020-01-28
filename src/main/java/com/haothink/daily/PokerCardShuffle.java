package com.haothink.daily;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by wanghao on 2020-01-28
 * mail:wanghaotime@qq.com
 *
 *
 * 简单的洗牌算法：
 *
 **/
public class PokerCardShuffle {


    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(nums));
        shufflePoker(nums);
        System.out.println(Arrays.toString(nums));
    }


    private static void shufflePoker(int[] pokerNums){


        Random random = new Random();
        for(int i=pokerNums.length-1;i>0;i--){

            int index = random.nextInt(i);
            //跟i位置的元素交换
            int temp = pokerNums[index];
            pokerNums[index] = pokerNums[i];
            pokerNums[i] = temp;

        }
    }


}
