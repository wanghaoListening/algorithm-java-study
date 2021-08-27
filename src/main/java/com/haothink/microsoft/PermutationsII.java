package com.haothink.microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wanghao on 2021/8/26
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 *Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 求所有排列组合，自然想到DFS，因为递归能够穷举所有情况，而递归重要的是由结束条件，以免进入死循环。
 **/
public class PermutationsII {

  List<List<Integer>> resultList = new ArrayList<>();
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> resultList = new ArrayList<>();
    dfs(nums,new boolean[nums.length],new ArrayList<>());
    return resultList;
  }

  private void dfs(int[] nums,boolean[] visit,List<Integer> example){
    if(example.size() == nums.length){
      //how to remove duplicate
      resultList.add(new ArrayList<>(example));
      return;
    }
    Set<Integer> appeared = new HashSet<>();
    for(int i = 0;i < nums.length;i++){

      if (appeared.contains(nums[i]) || visit[i]) {
        continue;
      }
      appeared.add(nums[i]);
      example.add(nums[i]);
      visit[i] = true;
      dfs(nums,visit,example);
      example.remove(example.size() - 1);
      visit[i] = false;
    }
  }


}
