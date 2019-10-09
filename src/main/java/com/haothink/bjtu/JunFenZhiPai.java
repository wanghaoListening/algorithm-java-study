package com.haothink.bjtu;

import java.lang.Math;
import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年10月09日 11:09
 * description: 均分纸牌
 *
 * 题目描述
 * 有 N 堆纸牌，编号分别为 1，2，…, N。每堆上有若干张，但纸牌总数必为 N 的倍数。可以在任一堆上取若于张纸牌，然后移动。
 * 　　移牌规则为：在编号为 1 堆上取的纸牌，只能移到编号为 2 的堆上；在编号为 N 的堆上取的纸牌，只能移到编号为 N-1 的堆上；其他堆上取的纸牌，可以移到相邻左边或右边的堆上。
 * 　　现在要求找出一种移动方法，用最少的移动次数使每堆上纸牌数都一样多。
 *
 * 　　例如 N=4，4 堆纸牌数分别为：
 * 　　①　9　②　8　③　17　④　6
 * 　　移动3次可达到目的：
 * 　　从 ③ 取 4 张牌放到 ④ （9 8 13 10） -> 从 ③ 取 3 张牌放到 ②（9 11 10 10）-> 从 ② 取 1 张牌放到①（10 10 10 10）。
 *
 * 输入数据
 * N （ N  堆纸牌， 1 ≤ N ≤ 100 ）
 * A1 A2 … An （ N  堆纸牌，每堆纸牌初始数， l≤ Ai < 104 ）
 * 输出数据
 * 所有堆均达到相等时的最少移动次数。
 * 样例输入
 * 4
 * 9 8 17 6
 * 样例输出
 * 3
 *
 *
 */
public class JunFenZhiPai {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] strNum = scan.nextLine().split(" ");
        int[] num = new int[n];
        for(int i=0;i<strNum.length;i++){
            num[i] = Integer.parseInt(strNum[i]);
        }

        System.out.println(countStep(num,n));
    }


    private static int countStep(int num[], int n)
    {
        if(null == num || n <= 2){
            return 0;
        }

        int i,cnt/*总共移动牌数*/,tm/*移动次数*/;
        int avg=0;
        int[] a = new int[n];
        for (i=0; i<n; i++)
        {
            a[i] = num[i];
            avg += num[i];
        }
        avg /= n;
        cnt = 0;
        tm =0;

        for (i=0; i<n-1; i++)
        {
            if (a[i] - avg != 0 )
            {
                tm ++;
            }
            cnt += Math.abs(a[i] - avg);
            a[i+1] = a[i+1] + a[i] - avg;
        }

        return tm;
    }

}
