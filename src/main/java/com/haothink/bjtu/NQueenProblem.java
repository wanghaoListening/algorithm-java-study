package com.haothink.bjtu;

/**
 * Created by wanghao on 2019-12-20
 * mail:wanghaotime@qq.com
 *
 * 八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。该问题是国际西洋棋棋手马克斯·贝瑟尔于1848年提出：在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 *
 * 回溯算法也叫试探法，它是一种系统地搜索问题的解的方法。回溯算法的基本思想是：从一条路往前走，能进则进，不能进则退回来，换一条路再试。用回溯算法解决问题的一般步骤为：
 * 1)、定义一个解空间，它包含问题的解。
 * 2)、利用适于搜索的方法组织解空间。
 * 3)、利用深度优先法搜索解空间。
 * 4)、利用限界函数避免移动到不可能产生解的子空间。
 * 问题的解空间通常是在搜索问题的解的过程中动态产生的，这是回溯算法的一个重要特性。
 *
 * 思路：   用数组x[n]表示n后问题的解。
 *
 * 其中，x[i]表示皇后i放置在棋盘的第i行的第x[i]列。由于不容许将2个皇后放在同一列上，所以解向量中的x[i]互不相同。2个皇后不能放在同一斜线上是问题的隐约束。对于一般的n后问题，这一隐约束条件可以化成显约束的形式。如果将n*n 格的棋盘
 * 看做二维方阵，其行号从上到下，列号从左到右依次编号为1,2，...n。从棋盘左上角到右下角的主对角线及其平行线（即斜率为-1的各斜线）上，2个下标值的差（行号-列号）值相等。同理，斜率为+1的每条斜线上，2个下标值的和（行号+列号）值相等。
 * 因此，若2个皇后放置的位置分别是（i,j）和（k,l）,且 i-j = k -l 或 i+j = k+l，则说明这2个皇后处于同一斜线上。以上2个方程分别等价于i-k = j-l 和 i-k =l-j。由此可知，只要|i-k|=|l-j|成立，就表明2个皇后位于同一条斜线上。
 *
 *
 **/
public class NQueenProblem {


    private static int N = 8;

    //存储放置的位置下标 0-7分表标识第一行到第7行，而value则代表列标
    private static int[] nums = new int[N];

    public static void main(String[] args) {

        //从第1行开始
        search(0);
    }

    /**
     *
     * @param i
     *
     * 行号
     */
    private static void search(int i){

        if(i == N){
            //证明上一轮结果查找完成
            for(int index=0; index<N; index++){

                System.out.print("quene"+"["+index+"]"+"["+nums[index]+"]"+" ");
            }
            System.out.println();
            return;
        }

        //index 为列号
        for(int index=0; index < N; index ++){

            nums[i] = index;

            if(isvalidPlace(i)){

                search(i+1);
            }
        }

    }

    /**
     *
     * @param i
     *      行号
     * @return
     *      是否有效地方
     */
    private static boolean isvalidPlace(int i){

        for(int index=0;index<i;index++){

            if(nums[index] == nums[i] || Math.abs(i - index) == Math.abs(nums[i] - nums[index])){
                return false;
            }
        }
        return true;
    }

}
