package com.haothink.jzoffer;

import java.util.Arrays;

/**
 * @author wanghao
 * @date 2019年09月03日 19:36
 * description:数组中只出现一次的数字
 *
 * 题目描述：
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。
 *
 * 解题思路：
 * 由于任何一个数字异或它自己都等于0，所以我们可以试着把原数组分成两个子数组，使得每个数组包含一个只出现一次的数字，
 * 而其他数字都成对出现两次。如果这样拆分成两个数组，那么我们就可以按照之前的办法分别对两个数组进行异或运算找出两个
 * 只出现一次的数字。
 *
 * 我们还是从头到尾依次异或数组中的每个数字，那么最终得到的结果就是两个只出现一次的数字异或的结果。由于这两个数字不
 * 一样，所以异或的结果至少有一位为1，我们在结果数字中找到第一个为1的位置，记为index位，现在我们以第index位是不是
 * 1为标准把原数组拆分成两个子数组，第一个子数组中的数组第index位都为1，第二个子数组中的数组第index位都为0，那么只
 * 出现一次的数字将被分配到两个子数组中去，于是每个子数组中只包含一个出现一次的数字，而其他数字都出现两次。这样我们
 * 就可以用之前的方法找到数组中只出现一次的数字了。
 *
 */
public class NumberAppearOnlyOnce {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(findNumsAppearOnce(new int[]{1,2,1,4,12,4})));
    }



    private static int[] findNumsAppearOnce(int [] nums){

        int end = 0;
        for(int num : nums){
            end = end ^ num;
        }
        int index = 0;
        while((end & 1) == 0){
            //从左边数为1的位
            end = end >> 1;
            index ++;
        }
        int[] num1 = new int[1];
        int[] num2 = new int[1];

        for(int num : nums){
            if(isa1(num,index)){
                num1[0]=num1[0]^num;
            }else{
                num2[0]=num2[0]^num;
            }
        }

        return new int[]{num1[0],num2[0]};
    }


    public static boolean isa1(int num, int index){
        num = num >> index;
        return (num & 1) == 1;
    }

}
