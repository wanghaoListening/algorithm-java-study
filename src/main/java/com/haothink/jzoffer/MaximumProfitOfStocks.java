package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年09月16日 18:20
 * description: 股票的最大利润
 *
 * 题目描述：
 * 一只股票在某些时间节点的价格{9,11,8,5,7,12,16,14},求在哪个时间锻买入和卖出，利润最大。
 *
 *
 *
 * 解题思路：
 * 定义函数diff(i)为第i天卖出的最大利润，那么只需要在求第i天的时候记住前面i-1天的最小值。此题与剑指offer之连续子数组的最大和这个题目的
 * 思路类似，可以利用动态规划的方法，用函数diff(i)表示以第i天卖出的最大利润，而我们需要求出max[diff(i)]，其中0<=i<=n。
 * 当前num[i](当前值)-minNum(最小值)大于maxProfit(最大利润)将最大利润进行替换，而num[i](当前值)小于minNum(最小值)值时将最小值进行替换
 */
public class MaximumProfitOfStocks {


    public static void main(String[] args) {

        System.out.println(maximumProfit(new int[]{1,11,8,9,7,12,16,14}));
    }


    private static int maximumProfit(int[] num){

        if(null == num || num.length<=0){
            return -1;
        }

        int minNum = num[0];
        int maxProfit = 0;

        for(int i=1;i<num.length;i++){

            maxProfit = maxProfit==0?num[i]-minNum:((num[i]-minNum>maxProfit)?(num[i]-minNum):maxProfit);
            minNum = minNum < num[i]?minNum:num[i];
        }
        return maxProfit;
    }

}
