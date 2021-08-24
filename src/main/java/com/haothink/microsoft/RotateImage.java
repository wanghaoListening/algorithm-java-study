package com.haothink.microsoft;

/**
 * Created by wanghao on 2021/8/23
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * First pass: mirror around diagonal
 * Second pass: mirror around y axis
 **/
public class RotateImage {



  public static void main(String[] args) {

    int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
    RotateImage rotateImage = new RotateImage();
    rotateImage.rotate(matrix);
  }


  public void rotate(int[][] matrix) {

    int n = matrix.length;
    int temp = 0;
    for (int i = 0; i < n; ++i)
      for (int j = i + 1; j < n; ++j){
        temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }

    for(int i=0; i<n; ++i){
      for(int j=0;j<n/2; ++j){
        temp = matrix[i][j];
        matrix[i][j] = matrix[i][n-1-j];
        matrix[i][n-1-j] = temp;
      }
    }
  }






}

