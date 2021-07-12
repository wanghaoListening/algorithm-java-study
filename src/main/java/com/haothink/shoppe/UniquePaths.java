package com.haothink.shoppe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021-07-12
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 *
 * Time Limit Exceeded
 **/
public class UniquePaths {


  public static void main(String[] args) {

    UniquePaths uniquePaths = new UniquePaths();

    System.out.println(uniquePaths.uniquePaths(3,7));
  }


  public int pathCount = 0;
  public int uniquePaths(int m, int n) {
    findPath(0,0,m,n);
    return pathCount;
  }


  private void findPath(int startM,int startN,int m,int n){

    if(startM == m-1 && startN == n-1){
      pathCount++;
      return;
    }
    if(startM>m-1 || startN>n-1){
      return;
    }

    findPath(startM+1,startN,m,n);
    findPath(startM,startN+1,m,n);
  }



}
