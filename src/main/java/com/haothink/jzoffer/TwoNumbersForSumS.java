package com.haothink.jzoffer;

import java.util.Arrays;

/**
 * @author wanghao
 * @date 2019年09月04日 14:05
 * description: 和为 S 的两个数字
 *
 * 题目描述：
 * 输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
 *
 * 解题思路：
 * 可以设置两个指针分别head,tail指向数组的头部和尾部，head向后移动，tail向前移动，移动的规则如下：
 *
 * 当num[head]+num[tail] == S 则找到元素
 * num[head]+num[tail] > S tail向前移动
 * num[head]+num[tail] < S head向后移动
 * 由于求的是num[head]*num[tail]最小的那对。所以我们需要一直重复上面过程，直到head>=tail
 *
 */
public class TwoNumbersForSumS {


    public static void main(String[] args) {

        int[] num = {1,2,3,4,6,7,8,8,10,12,15};
        System.out.println(Arrays.toString(findNumbersWithSum(num,16)));
    }



    private static int[] findNumbersWithSum(int[] num,int s){

        int head = 0,tail = num.length-1,preHead=0,preTail=0;
        int sum = 0;
        while (head < tail){

            if(num[head] + num[tail] == s){
                if(sum ==0 || num[head] * num[tail]<sum){
                    sum = num[head] * num[tail];
                    preHead = head;
                    preTail = tail;
                }
                head++;
            }else if(num[head] + num[tail] > s){
                tail --;
            }else{
                head ++;
            }
        }

        return sum > 0 ?new int[]{num[preHead],num[preTail]}:new int[]{};
    }

}
