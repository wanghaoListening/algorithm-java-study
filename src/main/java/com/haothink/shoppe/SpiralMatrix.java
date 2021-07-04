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
 *
 * [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 **/
public class SpiralMatrix {

  public static void main(String[] args) {

    int[][] matrix = {{7},{9},{6}};

    SpiralMatrix spiralMatrix = new SpiralMatrix();
    System.out.println(spiralMatrix.spiralOrder(matrix));
  }


  public List<Integer> spiralOrder(int[][] matrix) {


    int eleSum = matrix.length * matrix[0].length;
    List<Integer> results = new ArrayList<>(matrix.length * matrix[0].length);

    int fromWToEStart = 0;
    int fromWToEEnd = matrix[0].length-1;
    int fromNToSStart = 1;
    int fromNToSEnd = matrix.length-1;
    int fromEToWStart = matrix[0].length-2;
    int fromEToWEnd = 0;
    int fromSToNStart = matrix.length-2;
    int fromSToNEnd = 1;

    int fromWToERow = 0;
    int fromNToSColumn = matrix[0].length-1;
    int fromEToWRow = matrix.length-1;
    int fromSToNColumn = 0;

    int i=0;
    while (results.size() < eleSum){

      i = fromWToEStart;
      while ((fromEToWRow >=fromWToERow)&&i<=fromWToEEnd){

        results.add(matrix[fromWToERow][i]);
        i++;
      }
      fromWToEStart++;
      fromWToEEnd--;
      fromWToERow++;

      i= fromNToSStart;
      while ((fromNToSColumn>=fromSToNColumn)&&i<=fromNToSEnd){
        results.add(matrix[i][fromNToSColumn]);
        i++;
      }
      fromNToSStart++;
      fromNToSEnd--;
      fromNToSColumn--;

      i= fromEToWStart;
      while ((fromEToWRow >=fromWToERow)&& i>=fromEToWEnd){
        results.add(matrix[fromEToWRow][i]);
        i--;
      }
      fromEToWStart--;
      fromEToWEnd++;
      fromEToWRow--;
      i= fromSToNStart;
      while ((fromNToSColumn>=fromSToNColumn) && i>= fromSToNEnd){
        results.add(matrix[i][fromSToNColumn]);
        i--;
      }
      fromSToNStart--;
      fromSToNEnd++;
      fromSToNColumn++;
    }

    return results;
  }

}
