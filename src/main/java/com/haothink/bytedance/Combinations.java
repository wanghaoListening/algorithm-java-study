package com.haothink.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021/10/19
 *
 * Given two integers n and k, return all possible combinations of k
 * numbers out of the range [1, n].
 *
 * You may return the answer in any order.
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 **/
public class Combinations {


  public static void main(String[] args) {

    Combinations combinations = new Combinations();

    System.out.println(combinations.combine(4,2));
  }

  private List<List<Integer>> resultList = new ArrayList<>();

  public List<List<Integer>> combine(int n, int k) {


    dfsCombine(n,k,new ArrayList<>(),1);

    return resultList;
  }

  public void dfsCombine(int n,int k,List<Integer> result,int startIndex){

    if(null != result && result.size() == k){

      resultList.add(new ArrayList<>(result));
      return;
    }

    for(int i = startIndex;i<=n;i++){

      result.add(i);
      dfsCombine(n,k,result,i+1);
      result.remove(result.size()-1);
    }
  }

}
