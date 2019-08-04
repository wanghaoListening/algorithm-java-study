package com.haothink.bjtu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年08月04日 15:49
 * description: Cube
 *
 *题面描述
 * 给定一个盒子，长宽高分别为 a, b, c(1 <= a, b, c <= 100) 。有一个长度为 L 的木棍 (1 <= L <= 100) ，只记长度，能不能放到这个盒子里 ?
 *
 * 输入数据
 * 输入的第一行为一个正整数 T ，表示共有 T 组测试数据，随后的 T 行中每行为空格分隔的四个整数” a b c L ”，如上所述。
 *
 * 输出数据
 * 对每组测试数据，在单独的行中输出问题答案“ YES ”或“ NO ”，见样例。
 *
 * 样例输入
 * 2
 * 1 2 3 1
 * 5 5 5 100
 *
 * 样例输出
 * Case #1: YES
 * Case #2: NO
 *
 */
public class Cube {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int groupCount = Integer.parseInt(scan.nextLine());
        List<String> results = new ArrayList<>(groupCount);
        for(int i=0;i<groupCount;i++){
            String[] strs = scan.nextLine().split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            int c = Integer.parseInt(strs[2]);
            int l = Integer.parseInt(strs[3]);
            double result = Math.sqrt(a*a + b*b +c*c);
            if(result > l){
                results.add("YES");
            }else{
                results.add("NO");
            }
        }

        for(int i=0;i<results.size();i++){
            System.out.println("Case #"+(i+1)+": "+results.get(i));
        }
    }



}
