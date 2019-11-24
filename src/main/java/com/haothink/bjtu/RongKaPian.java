package com.haothink.bjtu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wanghao on 2019-11-24
 在桌子上有1摞卡片，每个卡片有一个正整数编号，从上到下卡片的编号为1到n，现在进行n次操作，每次操作先扔掉最顶端的卡片，然后将新的最顶端的卡片（如果有）放到这摞卡片的底部。 设第i次操作扔掉了编号为j的卡片（i从1开始），那么这次操作能加的分数为j%i分，求n次操作完成后的总分。

 输入数据
 一个正整数n，n<1000000

 输出数据
 每次扔掉卡片的编号，中间用空格分隔

 样例输入
 7
 样例输出
 18
 *
 *
 **/
public class RongKaPian {


    public static void main(String[] args) {

        long sum = 0;

        Scanner scan = new Scanner(System.in);
        String initLine = scan.nextLine();
        long n = Long.parseLong(initLine);
        List<Long> heapNums = new LinkedList<>();

        for(long i=1;i<=n;i++){
            heapNums.add(i);
        }

        int count = 1;

        while (count <= n){

            long removeEle = heapNums.remove(0);

            if(heapNums.size() >=2) {
                long moveEle = heapNums.remove(0);
                heapNums.add(moveEle);
            }

            sum+=(removeEle % count);
            count++;
        }


        System.out.println(sum);
    }
}
