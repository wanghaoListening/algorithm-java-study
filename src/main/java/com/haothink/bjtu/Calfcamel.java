package com.haothink.bjtu;

import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年07月26日 11:02
 * description: calfcamel的2333
 *
 * 题面描述
 * 为祝贺新一批的研究生入学，队长让大家为新人命题训练其程序设计能力。有人问队长能不能黑，队长说可以黑但是不能黑那啥。大家很失望 2333 ，于是 calfcamel 决定出一道 2333 的题目。
 *
 * 给你一个小于 60 位的整数 p ，求大于 p 的最小的数 p1 ，使得 p1 中包含数 2333 。
 *
 * 输入数据
 * 输入数据的第一行为一个正整数 T ，表示有 T 组数据。随后的 T 行中每行包括一个小于 60 位的整数 p （ T <= 50 ， 1 <= p <10^60 ，即 10 的 60 次方）。
 *
 * 输出数据
 * 对每组输入数据单独输出一行结果，第 x 行结果形如 ”Case #x: a“ ，其中 x 为组号，从 1 开始， a 为对应的结果。
 *
 * 样例输入
 * 2
 * 100
 * 1000000000000
 *
 * 样例输出
 * Case #1: 2333
 * Case #2: 1000000002333
 *，python中数字对象可以无限大下去，所以内存分配是在一个基础之上动态分配的。
 * lines=input()
 * for time in range(int(lines)):
 *     value=int(input())+1
 *     while True:
 *         if "2333" in str(value):
 *             monitor=value
 *             break
 *         elif value<=2333:
 *             monitor=2333
 *             break
 *         else:
 *             value+=1
 *     print("Case #"+str(time+1)+": "+str(monitor))
 */
public class Calfcamel {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        String numOfExample = scan.nextLine();
        String[] lines = new String[Integer.parseInt(numOfExample)];
        for(int i=0;i<Integer.parseInt(numOfExample);i++){
            String line = scan.nextLine();
            lines[i] = line;
        }

        for(int i=0;i<lines.length;i++){
            String pi = minP1(lines[i]);
            System.out.println("Case #"+(i+1)+": "+pi);
        }

    }

    private static String minP1(String inputLine){

        int value = Integer.parseInt(inputLine) +1 ;

        int monitor;
        while (true){

            if(String.valueOf(value).contains("2333")){
                monitor = value;
                break;
            }else if(value <= 2333){
                monitor = 2333;
                break;
            }else{
                value+=1;
            }
        }
        return monitor+"";
    }
}
