package com.haothink.shoppe;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanghao on 2021/7/20
 *
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is
 * connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
 * and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 **/
public class NumberOfProvinces {

  public static void main(String[] args) {

  }

  public int findCircleNum(int[][] isConnected) {

    Map<Integer,Integer> provinces = new HashMap<>();

    for(int i=0;i<isConnected.length;i++){

      for(int j=0;j<isConnected[0].length;j++){

        if(i != j && isConnected[i][j] == 1){
          provinces.put(i,j);
        }
      }
    }
    return provinces.size();
  }
}
