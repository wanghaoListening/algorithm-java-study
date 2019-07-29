package com.haothink.bjtu;

import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年07月29日 16:57
 * description: 求位数
 *
 * 题面描述
 *
 * 小 A 现在高一，却什么都学不会。老师给小 A 留了许多作业，让他计算一些数字经过幂运算后的位数。这对于小 A 来说实在太难了，于是来请教聪明的你。你能帮帮小 A 吗？
 *
 * 这道题目可以简化为如下内容：试求 ak 的值在十进制下有多少位。
 *
 * 输入数据
 *
 * 第一行有一个整数 t (1 ≤ t ≤ 100) ，表示有 t 组数据。
 *
 * 对于每组数据：
 *
 * 第一行有两个正整数 a,k (1 ≤ a ≤ 9,0 ≤ k ≤ 9) 。
 *
 * 输出数据
 *
 * 对于每组数据，输出一行，该行有一个整数，表示 ak 的位数。
 *
 * 样例输入
 *
 * 2
 * 2 4
 * 5 3
 *
 * 样例输出
 *
 * 2
 * 3
 */
public class NumberOfDigit {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int groupCount = Integer.parseInt(scan.nextLine());
        String[] lines = new String[groupCount];
        for(int i=0;i<groupCount;i++){

            lines[i] = scan.nextLine();
        }

        for(int i=0;i<lines.length;i++){

            String[] nums = lines[i].split(" ");
            Double result = Math.pow(Double.parseDouble(nums[0]),Double.parseDouble(nums[1]));
            int numberOfDight = (result.intValue()+"").length();
            System.out.println(numberOfDight);

        }

    }



}
