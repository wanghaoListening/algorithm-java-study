package com.haothink.bytedance;

import java.util.Arrays;

/**
 * Created by wanghao on 2021/9/8
 *
 * Write an efficient algorithm that searches for a target value in an m x n integer matrix.
 * The matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 *
 * 使用二分查找，对每行进行二分查找
 **/
public class SearchA2DMatrixII {


  public static void main(String[] args) {

    int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

    SearchA2DMatrixII searchA2DMatrixII = new SearchA2DMatrixII();
    System.out.println(searchA2DMatrixII.searchMatrix(matrix,5));
  }

  public boolean searchMatrix(int[][] matrix, int target) {

    int rows = matrix.length;

    for(int i=0;i<rows;i++){

      int index = Arrays.binarySearch(matrix[i],target);
      if(index < 0){
        continue;
      }
      return true;
    }
    return false;
  }
}
