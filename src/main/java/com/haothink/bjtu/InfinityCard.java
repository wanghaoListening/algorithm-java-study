package com.haothink.bjtu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年08月04日 16:36
 * description: Infinity的卡牌
 *
 * 题面描述
 * Infinity 最近迷上了一款卡牌游戏。某天， Infinity 构建了一个卡组，卡组中所有不同的卡牌都有两张。然而 Infinity 在查看他的卡组的时候手一滑，不小心删掉了一张卡牌。 Infinity 很想知道少了哪张卡牌。
 *
 * 由于 Infinity 的卡组实在是太大了，你能帮帮他吗？
 *
 * 输入数据
 * 输入数据的第一行为一个整数 T(1 <= T <= 10) ，表示有 T 组测试数据。每组数据的第一行为一个整数 n(2 <= n <=100000) ， n 为偶数，表示一个卡组中卡牌的数量。接下来的一行有 n - 1 个整数，为剩余牌的编号，其中相同牌的编号相同，不同牌的编号不同。
 *
 * 输出数据
 * 对于每组数据，在单独的一行中输出结果，为滑落牌的编号，格式见样例。
 *
 * 样例输入
 * 2
 * 2
 * 1
 * 4
 * 1 1 2
 *
 * 样例输出
 * Case #1: 1
 * Case #2: 2
 */
public class InfinityCard {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int groupCount = Integer.parseInt(scan.nextLine());
        List<Integer> results = new ArrayList<>(groupCount);
        for(int i=0;i<groupCount;i++){
            scan.nextLine();
            String[] strs = scan.nextLine().split(" ");
            int result = Integer.parseInt(strs[0]);
            for(int j=1;j<strs.length;j++){

                result = result ^ Integer.parseInt(strs[j]);
            }
            results.add(result);
        }

        for(int i=0;i<results.size();i++){
            System.out.println("Case #"+(i+1)+": "+results.get(i));
        }
    }


}
