package com.haothink.bytedance;

/**
 * Created by wanghao on 2021/9/16
 *
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 *
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 *
 * 初始对角线方向为右上方（偏移量：行-1, 列+1），遇到边界时转向左下方（偏移量：行+1, 列-1）
 *
 * 向右上方移动遇到上边界时，若未达到右边界，则向右移动（偏移量：行+0，列+1），否则向下移动（偏移量：行+1，列+0）
 * 向左下方移动遇到左边界时，若未达到下边界，则向下移动（偏移量：行+1，列+0），否则向右移动（偏移量：行+0，列+1）
 *
 **/
public class DiagonalTraverse {

  public int[] findDiagonalOrder(int[][] mat) {

    int row = mat.length;
    int column = mat[0].length;
    int[] result = new int[row*column];




    return result;
  }
}
