package com.haothink.bjtu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年08月07日 14:47
 * description: Tower of Hanoi
 *
 * 题面描述
 *
 * 变种汉诺塔问题和普通汉诺塔问题略有不同，规则描述如下：
 *
 * 1. 有三根柱子，在最左侧柱子上放置着若干圆盘。与传统汉诺塔不同的是，其中存在部分大小相同的圆盘。
 *
 * 2. 要求包括初始状态在内，每个圆盘上方放置的圆盘不得大于该圆盘，即圆盘上方只能放置小于自己或和自己相同大小的圆盘。
 *
 * 3. 每次移动只能将某柱子最顶部的一个圆盘移动到另一柱子的最顶部。
 *
 * 4. 需要注意的是，大小相同的圆盘具有的其他特征是不一样的，例如不同颜色。
 *
 * 最后需要保证 2 号柱子上的圆盘排列顺序，和开始时的 0 号柱子上的顺序完全相同。
 *
 * 求将初态 0 号柱子上的所有圆盘全部移到 2 号柱子上最优策略的步数 l 对 m 取模后的值。
 *
 * 输入数据
 * 对于每组数据：
 *
 * 第一行有一个整数 t (1 ≤ t ≤ 100 ) ，表示有 t 组数据。
 * 第一行包括 2 个数字 n,m (1≤n≤15000, 1≤m≤1000000) ，其中 n 代表圆盘种类的个数；
 *
 * 第二行包括 n 个数字 a1, … , an (1 ≤ ai≤ 99 )，其中 ai 代表大小为 i 的圆盘个数。
 *
 * 输出数据
 * 对于每组数据，输出一行，若最优策略的步数为 l ，则输出 l mod m 。
 *
 * 样例输入
 * 2
 * 2 1000
 * 1 2
 * 3 1000
 * 1 2 3
 * 样例输出
 * 7
 * 21
 */
public class TowerOfHanoi {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int groupCount = Integer.parseInt(scan.nextLine());
        List<Integer> results = new ArrayList<>();

        for(int i=0;i<groupCount;i++){

            String[] vts = scan.nextLine().split(" ");
            int n = Integer.valueOf(vts[0]);
            int m = Integer.valueOf(vts[1]);
            int[] a = new int[n];
            String[] ns = scan.nextLine().split(" ");
            for(int j=0;j<n;j++){
                a[j] = Integer.valueOf(ns[j]);
            }
            int[] temp = new int[n];
            temp[0] = a[0];
            for(int j=1;j<n;j++){
                temp[j] = (2*temp[j-1] + a[j]) %m;
            }
            int[] sum = new int[n];
            sum[0] = (2*a[0]-1);
            for(int j=1;j<n;j++){
                if(a[j] == 1){
                    sum[j] = (2 * temp[j-1])%m +1;
                }else {
                    sum[j] = (2 * temp[j-1] + 2* a[j])%m + sum[j-1];
                }
            }
            results.add(sum[n-1]%m);

        }

        for(int i=0;i<results.size();i++){
            System.out.println(results.get(i));
        }
    }



}
