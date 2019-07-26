package com.haothink.bjtu;

import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年07月12日 17:56
 * description: 连续数的和
 *
 * 题面描述
 * 对于一个给定的正整数 n ，请你找出一共有多少种方式使 n 表示为若干个连续正整数的和，要求至少包括两个正整数。如 n=15 时，可以有 3 种方式：（ 1+2+3+4+5 ），（ 4+5+6 ），（ 7+8 ）。
 *
 * 输入数据
 * 输入数据第一行为一个正整数 T ，表示测试数据的组数。 随后的 T 行中，每行包括一组测试数据，为一个整数 n（1≤T≤1000,n≤10^9）。
 *
 * 输出数据
 * 对每一组输入数据，输出一行结果 ”Case #id: M” ，表示第 id 组数据的结果是 M ， id 从 1 开始。
 *
 * 样例输入
 * 2
 * 3
 * 15
 *
 * 样例输出
 * Case #1: 1
 * Case #2: 3
 *
 * https://blog.csdn.net/lsjweiyi/article/details/63684123
 */
public class LxsSum {


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        String numOfExample = scan.nextLine();
        int[] params = new int[Integer.parseInt(numOfExample)];
        for(int i=0;i<Integer.parseInt(numOfExample);i++){
            String line = scan.nextLine();
            params[i] = Integer.parseInt(line);

        }

        for(int i=0;i<params.length;i++){
            int balls = arithmeticSquence(params[i]);
            System.out.println("Case #"+(i+1)+": "+balls);
        }

    }


    private static int arithmeticSquence(int n){

        //用来作为记录有多少组连续整数，也用来在输出连续整数时添加逗号的标记
        int count=0;
        //i表示该整数由i个连续整数相加
        for(int i=2;i<=n/2+1;i++){

            //当该整数由i个连续整数相加时，这些连续整数的最小值的表达式
            int value=n/i-(i-1)/2;

            //最小取1
            if(value<1) {
                break;
            }
            //等差数列，首相加末项乘以项数除以2
            int temp=(value+value+i-1)*i/2;
            //成功找到连续整数
            if(temp==n){
                //记录有多少组连续整数组
                count++;
            }
        }
        return count;
    }

}


