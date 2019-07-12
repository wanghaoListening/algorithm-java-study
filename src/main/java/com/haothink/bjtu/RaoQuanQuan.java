package com.haothink.bjtu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年07月12日 14:32
 * description: 绕圆圈
 *
 * 小明报名参加了趣味运动会，运动会游戏规则如下：在一个环形跑道上，等距离放置着 N 个小球，小球按照顺时针方向从起点开始依次编号
 * 为 1 到 N ，在最短时间内取走放在跑道上尽可能多小球的选手获胜。举办方要求每个选手只能按照顺时针方向，跳过 M-1 个号码取后走
 * 下一个小球。如当 N=5 、 M=3 时，小明能够取走所有的小球，取走的顺序依次为 1->4->2->5->3 。当 N=6 、 M=2 时，小明只能取走
 * 3 个小球 1->3->5 。小明想知道在一场比赛中他最多能取走多少小球，当然，小明是知道怎么做的，但是他忙着补作业，所以这个简单的
 * 问题就交 (shuai guo) 给你了。
 *
 * 输入数据
 * 输入数据的第一行为一个整数 T ，表示有 T 组测试样例。每组样例为单独的一行，包括两个整数 N 和 M 。
 *
 * 输出数据
 * 对每一组输入数据，输出一行结果 ”Case #id: M” ，表示第 id 组数据的结果是 M ， id 从 1 开始。
 */
public class RaoQuanQuan {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String numOfExample = scan.nextLine();

        for(int i=1;i<=Integer.parseInt(numOfExample);i++){
            String line = scan.nextLine();
            String[] nums = line.split(" ");
            int balls = numberOfBall(Integer.parseInt(nums[0]),Integer.parseInt(nums[1]));
            System.out.println("Case #"+i+":"+balls);
        }

    }


    /**
     *
     * @param n
     *        一共n个小球
     * @param m
     *        跳过 n-1 个号码取后走下一个小球
     * @return
     *
     *       能够获取的小球数
     */
    private static int numberOfBall(int n,int m){

        int[] runwayNum = new int[n+1];
        Arrays.fill(runwayNum,1);
        int count = 0;
        //从1开始，0位置不进行处理
        int index = 1;
        int currentNum = runwayNum[index];
        while (currentNum !=0){
            count++;
            //将取走的位置，赋值为0
            runwayNum[index] = 0;
            if((index+m) > (n-1)){
                index = m - (n - index);

            }else{
                index = index + m;
            }

            currentNum = runwayNum[index];
        }
        return count;
    }


}
