package com.haothink;

/**
 * @author wanghao
 * @date 2019年06月11日 23:01
 * description:
 *
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
 *
 * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。因此，从右上角开始查找，
 * 就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素
 */
public class TwoDimensionalArraySearch {


    public static void main(String[] args) {

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
                };
        System.out.println(findTarget(20,matrix));

    }

    private static boolean findTarget(int target,int[][] matrix){

        //最小列索引
        int columnMinIndex = 0;

        //最大行索引
        int rowMaxIndex = matrix.length-1;

        //列长
        int columnIndex = matrix[0].length-1;
        int rowIndex = 0;

        //右上角元素
        int startValue = matrix[rowIndex][columnIndex];

        while (target != startValue){

            if(target > startValue){
                if(rowIndex == rowMaxIndex){
                    return false;
                }
                rowIndex+=1;
                startValue = matrix[rowIndex][columnIndex];
            }else {
                if(columnIndex == columnMinIndex){
                    return false;
                }
                columnIndex-=1;
                startValue = matrix[rowIndex][columnIndex];
            }

        }

        return true;

    }

}
