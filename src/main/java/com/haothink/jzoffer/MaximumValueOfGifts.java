package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年08月19日 19:15
 * description: 礼物的最大价值
 *
 * 题目描述：
 * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。
 *
 * 1    10   3    8
 * 12   2    9    6
 * 5    7    4    11
 * 3    7    16   5
 *
 * 礼物的最大价值为 1+12+5+7+7+16+5=53。
 *
 * 解题思路：
 *
 * 用动态规划的思路，定义f(i,j)表示到达坐标为(i,j)的格子时能拿到的礼物总和的最大值；
 * 则f(i,j)的最大值公式为f(i,j) = max(f(i-1,j), f(i,j-1)) + gift[i,j]；
 *
 *
 */
public class MaximumValueOfGifts {


    public static void main(String[] args) {

        int[][] matrix = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(solution(matrix));
    }


    private static int solution(int[][] matrix){

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] maxValues = new int[rows][cols];

        for (int i = 0; i < rows; ++i)
        {
            for (int j = 0; j < cols; ++j)
            {
                //左边
                int fromLeft = 0;
                //上面
                int fromUp = 0;
                if (i > 0) {
                    fromLeft = maxValues[i - 1][j];
                }
                if (j > 0) {
                    fromUp = maxValues[i][j - 1];
                }
                maxValues[i][j] = Math.max(fromLeft, fromUp) + matrix[i][j];
                System.out.println("maxValue"+maxValues[i][j]);
            }
        }

        return maxValues[rows - 1][cols - 1];
    }

}
