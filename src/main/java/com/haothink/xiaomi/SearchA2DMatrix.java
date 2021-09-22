package com.haothink.xiaomi;

import java.util.Arrays;

/**
 * Created by wanghao on 2021/9/22
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 * //每行进行二分查找
 **/
public class SearchA2DMatrix {

  public static void main(String[] args) {

    int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

    SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();

    System.out.println(searchA2DMatrix.searchMatrix(matrix,3));
  }

  public boolean searchMatrix(int[][] matrix, int target) {

    int rows = matrix.length;
    for(int i=0;i<rows;i++){

      int index = Arrays.binarySearch(matrix[i],target);
      if(index >= 0){
        return true;
      }
    }
    return false;
  }
}
