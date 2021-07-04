package com.haothink.shoppe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021-07-03
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * 分四个方向对元素进行遍历，关键是控制好四个拐角的转向问题，East，South，West，North 或者上下左右四个方向
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 **/
public class SpiralMatrix {

  public static void main(String[] args) {


  }


  public List<Integer> spiralOrder(int[][] matrix) {


    int eleSum = matrix.length * matrix[0].length;
    List<Integer> results = new ArrayList<>(matrix.length * matrix[0].length);

    int fromWToEStart = 0;
    int fromWToEEnd = matrix[0].length;
    int fromNToSStart = 1;
    int fromNToSEnd = matrix.length-1;
    int fromEToWStart = matrix[0].length-2;
    int fromEToWEnd = 0;
    int fromSToNStart = matrix.length-2;
    int fromSToNEnd = 2;

    while (results.size() < eleSum){




    }

    return null;
  }

}
