package com.haothink.jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanghao
 * @date 2019年08月17日 10:27
 * description: 把数字翻译成字符串
 *
 * 题目描述：
 * 给定一个数字，按照如下规则翻译成字符串：0翻译成“a”，1翻译成“b”...25翻译成“z”。一个数字有多种翻译可能，例如12258一共有5种，分别是bccfi，bwfi，bczi，mcfi，mzi。实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * digital-translation-to-string.jpg
 * 解题思路：
 *
 * 第一种方式：可以采用自上而下的方式进行递归遍历。从字符串的左边到右边不断取1-2个字符直到到达最后的位置最后进行统计
 * 第二种方式：利用动态规划的思想，dp[i]表示位置i之前（不包括位置i）总共有多少种翻译方法，
 * 当s[i-2:i]这两个字符是10-25时，比如21，此时有两种翻译方式，所以dp[i] = dp[i-1] + dp[i-2]。
 * 当s[i-2:i]这两个字符不在上述范围，比如39，比如00，此时只有一种翻译方式，所以dp[i] = dp[i-1]。
 * 注意初始化时，dp[0] = 1, dp[1] = 1.
 *
 *
 */
public class DigitalTranslationToString {


    private static int count = 0;
    public static void main(String[] args) {

        System.out.println(transToStr(12258));
        System.out.println(dpCountPattern(12258));
    }



    private static int transToStr(int number){
        if(number <0){
            return 0;
        }
        char[] chs = String.valueOf(number).toCharArray();
        int[] numbers = new int[chs.length];
        for(int i=0;i<numbers.length;i++){
            //利用Ascii码的性质
            numbers[i] = chs[i] - 48;
        }

        countPattern(numbers,0);
        return count;
    }

    //递归
    private static void countPattern(int[] nums,int index){

        if(index >= nums.length-1){
            //证明有一种情况已经走到头了。
            ++count;
        }else{
            if(0<=nums[index] && nums[index]<=25){
                countPattern(nums,index+1);
            }

            if((nums.length-1-index) >=2 && (nums[index]*10+nums[index+1])<=25){
                countPattern(nums,index+2);
            }
        }

    }


    //动态规划实现,待解决
    private static int dpCountPattern(int number){
        if(number <0){
            return 0;
        }
        char[] chs = String.valueOf(number).toCharArray();
        int[] numbers = new int[chs.length];
        for(int i=0;i<numbers.length;i++){
            //利用Ascii码的性质
            numbers[i] = chs[i] - 48;
        }

        List<Integer> dp = new ArrayList<>();

        dp.add(1);
        dp.add(1);

        int index = dp.size();

        while (index < numbers.length){

            if(10 <=(numbers[index-2]*10+numbers[index-1]) && (numbers[index-2]*10+numbers[index-1])<=25){
                dp.add(dp.get(index-1) + dp.get(index-2));
            }else{
                dp.add(dp.get(index-1));
            }
            index++;
        }
        System.out.println(dp);
        return dp.get(dp.size()-1);

    }



}
