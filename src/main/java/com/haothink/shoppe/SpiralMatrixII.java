package com.haothink.shoppe;



/**
 * Created by wanghao on 2021-07-05
 *
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 **/
public class SpiralMatrixII {

  public static void main(String[] args) {

  }

  public int[][] generateMatrix(int n) {


    int eleSum = n * n;
    int[][] eleMatrix = new int[n][n];

    int fromWToEStart = 0;
    int fromWToEEnd = eleMatrix[0].length-1;
    int fromNToSStart = 1;
    int fromNToSEnd = eleMatrix.length-1;
    int fromEToWStart = eleMatrix[0].length-2;
    int fromEToWEnd = 0;
    int fromSToNStart = eleMatrix.length-2;
    int fromSToNEnd = 1;

    int fromWToERow = 0;
    int fromNToSColumn = eleMatrix[0].length-1;
    int fromEToWRow = eleMatrix.length-1;
    int fromSToNColumn = 0;

    int i=0;
    int eleNum = 1;
    while (eleNum <= eleSum){

      i = fromWToEStart;
      while ((fromEToWRow >=fromWToERow)&&i<=fromWToEEnd){

        eleMatrix[fromWToERow][i] = eleNum;
        eleNum++;
        i++;
      }
      fromWToEStart++;
      fromWToEEnd--;
      fromWToERow++;

      i= fromNToSStart;
      while ((fromNToSColumn>=fromSToNColumn)&&i<=fromNToSEnd){
        eleMatrix[i][fromNToSColumn] = eleNum;
        eleNum++;
        i++;
      }
      fromNToSStart++;
      fromNToSEnd--;
      fromNToSColumn--;

      i= fromEToWStart;
      while ((fromEToWRow >=fromWToERow)&& i>=fromEToWEnd){
        eleMatrix[fromEToWRow][i] = eleNum;
        eleNum++;
        i--;
      }
      fromEToWStart--;
      fromEToWEnd++;
      fromEToWRow--;
      i= fromSToNStart;
      while ((fromNToSColumn>=fromSToNColumn) && i>= fromSToNEnd){
        eleMatrix[i][fromSToNColumn] = eleNum;
        eleNum++;
        i--;
      }
      fromSToNStart--;
      fromSToNEnd++;
      fromSToNColumn++;
    }

    return eleMatrix;
  }
}
