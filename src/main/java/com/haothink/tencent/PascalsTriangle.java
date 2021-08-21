package com.haothink.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021/8/19
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 **/
public class PascalsTriangle {

  public static void main(String[] args) {

    PascalsTriangle pascalsTriangle = new PascalsTriangle();
    System.out.println(pascalsTriangle.generate(5));
  }

  public List<List<Integer>> generate(int numRows) {

    List<List<Integer>> pascalsTriangleList = new ArrayList<>();
    for(int i=1;i<=numRows;i++){
      List<Integer> rowList = new ArrayList<>();
      for(int j=1;j<=i;j++){
        if(i <= 2){
          rowList.add(1);
        }else {
          if(j==1 || j==i){
            rowList.add(1);
          }else {
            List<Integer> preList = pascalsTriangleList.get(i-2);
            rowList.add(preList.get(j-2)+preList.get(j-1));
          }
        }
      }
      pascalsTriangleList.add(rowList);
    }
    return pascalsTriangleList;
  }
}
