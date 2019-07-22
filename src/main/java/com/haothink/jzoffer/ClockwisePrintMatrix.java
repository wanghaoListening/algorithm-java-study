package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年07月22日 17:43
 * description: 顺时针打印矩阵
 *
 * 描述：
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次扫印出每一个数字
 *
 * 思路：
 * 顺时针在矩阵中打印每一个数字，一共分四个方向
 *
 * 1.行号不动，列号递增，
 *
 * 2.列号不动，行号递增
 *
 * 3.行号不动，列号递减
 *
 * 4.列号不动，行号递减
 *
 * 所以我们只需要在这四个方向控制好下标打印即可，当行号的起始索引等于其结束索引，列号的起始索引等于其列号的结束索引则结束程序
 */
public class ClockwisePrintMatrix {


    public static void main(String[] args) {

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(matrix);

    }


    private static void printMatrix(int[][] matrix){

        //行起始位置
        int rowStart = 0;
        //行结束位置
        int rowEnd = matrix[0].length-1;

        //列起始位置
        int columnStart = 0;
        //列结束位置
        int columnEnd = matrix.length-1;

        while (true){

            if((rowStart >= rowEnd) && (columnStart >= columnEnd)){
                break;
            }

            //行号不动，列递增
            for(int i=columnStart;i<=columnEnd;i++){
                System.out.println(matrix[columnStart][i]);
            }
            rowStart ++;
            //列不动，行递增
            for(int i=rowStart;i<=rowEnd;i++){
                System.out.println(matrix[i][columnEnd]);
            }
            columnEnd --;
            //行不动，列递减
            for(int i=columnEnd;i>=columnStart;i--){
                System.out.println(matrix[rowEnd][i]);
            }
            rowEnd --;
            //列不动，行递减
            for(int i=rowEnd;i>=rowStart;i--){
                System.out.println(matrix[i][columnStart]);
            }
            columnStart ++;

        }
    }

}
