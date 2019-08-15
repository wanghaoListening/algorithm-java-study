package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年08月14日 21:14
 * description: 从 1 到 n 整数中 1 出现的次数
 *
 * 题目描述：
 * 输入一个整数n，求1~n这n个整数的十进制表示中1出现的次数。
 *
 * 例子：
 * 例如输入12,1~12这些整数中包含1的数字有1、10、11和12，1一共出现了5次。
 *
 * 解题思路：
 * 这道题最容易想到的就是逐个遍历，然后判断每个数字包含1的个数。
 *
 *
 *
 */
public class FrequencyOfOneNumFromOneToN {

    public static void main(String[] args) {

        System.out.println(numberOfOne(12));
    }


    private static int numberOfOne(int number){

        int count = 0;
        for(int i=1;i<=number;i++){
            int temp = i;
            while (temp>0){
                if(temp % 10 == 1) {
                    count++;
                }
                temp = temp/10;
            }
        }

        return count;
    }


}
