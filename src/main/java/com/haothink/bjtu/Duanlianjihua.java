package com.haothink.bjtu;

import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年07月29日 17:52
 * description: 锻炼计划
 *
 * 题面描述
 *
 * 老顽童是一个热爱运动的人，每天都有小顽童来和他一起锻炼。为了让锻炼更有成效，他想要制定一份锻炼计划，让第 n 天的训练量要等于第 n 个正回文数 ( 第 1 个正回文数是 1) 。
 *
 * 老顽童已经打印好了计划表，但是他的计划表中有一些日子被遗漏了，他又不想重新计算，你可以帮他解决这个问题吗？
 *
 * 如果一个数的各位数字反向排列后仍然等于其本身，则把这样的数称为回文数 (palindrome number) ，如 12321 是回文数， 1232 不是回文数。
 *
 * 输入数据
 *
 * 第一行有一个整数 t (1 ≤ t ≤ 100000) ，表示有 t 组数据。
 *
 * 每组数据只有一行，为一个整数 n (1 ≤ n ≤ 400000) ，表示第 n 天。
 *
 * 输出数据
 *
 * 对于每组数据，输出一个整数，表示对应的训练量。
 *
 * 样例输入
 *
 * 5
 * 1
 * 2
 * 3
 * 12
 * 23
 *
 * 样例输出
 *
 * 1
 * 2
 * 3
 * 33
 * 141
 */
public class Duanlianjihua {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int groupCount = Integer.parseInt(scan.nextLine());
        int[] numbers = new int[groupCount];
        for(int i=0;i<groupCount;i++){
            numbers[i] = Integer.parseInt(scan.nextLine());
        }

        for(int i=0;i<numbers.length;i++){
            System.out.println(huiWen(numbers[i]));
        }
    }


    private static String huiWen(int n){

        StringBuilder huiwenNumber = new StringBuilder();
        int s = 9 , ans = 1 ;
        while(n > s * 2) {
            n -= s * 2 ;
            s *= 10 ;
            ans *= 10 ;
        }
        ans += (n % s == 0 ? s : n % s) - 1 ;
        huiwenNumber.append(ans);
        if(n - s <= 0) {
            ans /= 10;
        }
        while(ans !=0) {
            huiwenNumber.append(ans % 10);
            ans /= 10 ;
        }

        return huiwenNumber.toString();
    }
}
