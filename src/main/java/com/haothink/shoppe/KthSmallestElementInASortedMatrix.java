package com.haothink.shoppe;

/**
 * Created by wanghao on 2021/7/29 mail:hiwanghao@didiglobal.com
 *
 * Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth
 * smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 *
 * [[1,2],[1,3]]
 * 1
 *
 *
 **/
public class KthSmallestElementInASortedMatrix {

  public static void main(String[] args) {

    int[][] matrix = {{1,2},{1,3}};

    KthSmallestElementInASortedMatrix kthSmallestElementInASortedMatrix = new KthSmallestElementInASortedMatrix();
    System.out.println(kthSmallestElementInASortedMatrix.kthSmallest(matrix,1));
  }

  public int kthSmallest(int[][] matrix, int k) {

    int n = matrix.length;
    int l = matrix[0][0], r = matrix[n - 1][n - 1];
    while (l < r) {
      int mid = l + ((r - l) >> 1);
      int temp = 0;
      for (int i = 0; i < n; i++) temp += binarySearch(matrix[i], n, mid);
      if (temp < k) l = mid + 1;
      else r = mid;
    }
    return l;
  }

  private int binarySearch(int[] row,int r,int x){
    int l = 0;
    while (l < r){
      int mid = (l + r) >> 1;
      if(row[mid] <= x) l = mid + 1;
      else r = mid;
    }
    return l;
  }
}
