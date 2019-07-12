package com.haothink.bjtu;

import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年07月12日 16:11
 * description: 互素
 *
 * 题面描述
 * 小明很喜欢学数学，并且喜欢做一些奇怪的题，这天他想知道对于给定的 N ，有多少个 M 满足“ M<=N, gcd(N,M)==1, M 是偶数”。请你编写程序帮助小明解决这个问题。
 *
 * 输入数据
 * 输入数据第一行为一个正整数 T ，表示测试数据的组数。 接下来的 T 组测试数据中， 每组测试数据为一行，包含一个整数 N （1≤T≤100， 1≤N≤10000 ）。
 *
 * 输出数据
 * 对于每一组输入数据，在单独的一行中输出 ”Case #id: M”, 表示第 id 组数据结果是 M ， id 从 1 开始；
 *
 * 样例输入
 * 4
 * 1
 * 2
 * 11
 * 23
 *
 * 样例输出
 * Case #1: 0
 * Case #2: 0
 * Case #3: 5
 * Case #4: 11
 *
 * Hint:
 * gcd(a,b)==1 表示 a 与 b 的最大公约数为 1 ，即 a 与 b 互素。
 */
public class HuSu {


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        String numOfExample = scan.nextLine();

        for(int i=1;i<=Integer.parseInt(numOfExample);i++){
            String line = scan.nextLine();
            int balls = hint(Integer.parseInt(line));
            System.out.println("Case #"+i+":"+balls);
        }
    }


    /**
     *
     * @param n
     *       给定数值n
     * @return
     *       返回符合条件的m数量
     */
    private static int hint(int n){

        int count = 0;
        for(int i=1;i<=n;i++){

            if(i%2 == 0 && maxCommonDivisor(n,i) == 1){
                count++;
            }
        }
        return count;
    }

    /**
     * 递归求最大公约数
     * @param m
     * @param n
     * @return
     */
    private static int maxCommonDivisor(int m, int n) {
        if (m < n) {
            // 保证m>n,若m<n,则进行数据交换
            int temp = m;
            m = n;
            n = temp;
        }
        if (m % n == 0) {
            // 若余数为0,返回最大公约数
            return n;
        } else {
            // 否则,进行递归,把n赋给m,把余数赋给n
            return maxCommonDivisor(n, m % n);
        }
    }


}
