package com.haothink.bjtu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年08月04日 17:22
 * description: 懒羊羊吃青草
 *
 * 题面描述
 * 懒羊羊是一只非常能吃的羊，它在青青草原上发现一块巨大的正方形草地，但灰太狼已经抢先一步在草地上布下了若干陷阱。正方形草地位于直角坐标系中，左下角坐标为 (1, 1) ，右上角坐标为 (m, m) ，草地内只有整数坐标点上才长有青草。懒羊羊发现，对于一棵坐标为 (x, y) 处的青草，只有 (x*y) Mod m>0 时，草旁边才有一个陷阱， Mod 为取余数操作。
 *
 * 聪明的你是否能帮懒羊羊算一算，这块草地上共有多少陷阱。
 *
 * 输入数据
 * 输入数据的第一行为一个正整数 T(T<=50) ，表示测试数据的组数。接下来是 T 行测试数据，每行中有一个整数 m(m<=100000) 。
 *
 * 输出数据
 * 对于每一组测试数据，输出一行” Case id: M ”，表示第 id 组测试数据结果为， id 从 1 开始。
 *
 * 样例输入
 * 5
 * 1
 * 3
 * 4
 * 6
 * 1403
 *
 * 样例输出
 * Case #1: 0
 * Case #2: 4
 * Case #3: 8
 * Case #4: 21
 * Case #5: 1962964
 */
public class LanYangyangChiCao {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int groupCount = Integer.parseInt(scan.nextLine());
        List<Integer> results = new ArrayList<>(groupCount);
        for(int i=0;i<groupCount;i++){
            int m = Integer.parseInt(scan.nextLine());
            int count = 0;
            for(int j=1;j<=m;j++){
                for(int k=1;k<=m;k++){
                    if((j*k)%m > 0){
                        count ++;
                    }
                }
            }
            results.add(count);

        }

        for(int i=0;i<results.size();i++){
            System.out.println("Case #"+(i+1)+": "+results.get(i));
        }
    }
}
