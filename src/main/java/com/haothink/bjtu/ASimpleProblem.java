package com.haothink.bjtu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年08月06日 20:27
 * description: A Simple Problem
 *
 * 题面描述
 * 求 0~n 中有多少个整数 k 满足 (2 * k) XOR (3 * k) == k, 其中 XOR 为异或操作。
 *
 * 输入数据
 * 输入数据的第一行为一个正整数 T(T<=30) ，表示测试数据的组数。
 *
 * 接下来的 T 行中，每行为一组测试数据，包含一个正整数 n(n<=1000000000) 。
 *
 * 输出数据
 * 对每一组输入数据，输出一行结果 ”Case #id: M” ，表示第 id 组数据的结果是 M ， id 从 1 开始。
 *
 * 样例输入
 * 5
 * 0
 * 1
 * 2
 * 3
 * 4
 *
 * 样例输出
 * Case #1: 1
 * Case #2: 2
 * Case #3: 3
 * Case #4: 3
 * Case #5: 4
 *
 *
 */
public class ASimpleProblem {



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int groupCount = Integer.parseInt(scan.nextLine());
        List<Integer> results = new ArrayList<>(groupCount);

        for(int i=0;i<groupCount;i++){

            int n = Integer.valueOf(scan.nextLine());

            int count =0;
            for(int j=0;j<=n;j++){

                if(((2 * j) ^ (3 * j)) == j){
                    count ++;
                }
            }
            results.add(count);

        }

        for(int i=0;i<results.size();i++){
            System.out.println("Case #"+(i+1)+": "+results.get(i));
        }

    }




}
