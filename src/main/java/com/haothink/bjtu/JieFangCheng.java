package com.haothink.bjtu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wanghao on 2019-11-24
 题目描述
 设x为一个十进制正整数，定义s(x)为x的每一位上的数字之和，如s(123) = 1+2+3 = 6 对于如下方程：x = b*(s(x)^a)+c 给出a,b,c的值，要求找出[1,999999999]内所有符合条件的x，并从小到大输出

 输入数据
 三个正整数，分别代表a,b,c 1<=a<=5 1<=b<=10000 -10000<=c<=10000

 输出数据
 第一行为一个正整数n，代表符合条件的x的个数 第二行为n个递增的数，代表所有符合条件的x

 样例输入
 3 2 8
 样例输出
 3
 10 2008 13726
 **/
public class JieFangCheng {


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        String initLine = scan.nextLine();
        String[] nums = initLine.split(" ");

        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[1]);
        int c = Integer.parseInt(nums[2]);

        List<Integer> sums = new ArrayList<>();
        for(int i=1;i<=999999999;i++){

            Double end  = (b * (Math.pow(sum(i),a))+c);


            if(end.intValue() == i){
                sums.add(i);
            }
        }
        System.out.println(sums.size());
        for(Integer i : sums){
            System.out.print(i);
        }
    }

    private static int sum(int m){

        int sum = 0;
        while(m>0)
        {
            int i = m % 10;//计算每一位上的数字

            sum+=i;

            m = m / 10;//实现位与位之间的遍历
        }

        return sum;

    }

}
