package com.haothink.kuaishou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wanghao on 2021/9/30
 *
 * Given a collection of numbers, nums, that might contain duplicates,
 * return all possible unique permutations in any order.
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 **/
public class PermutationsII {

  List<List<Integer>> resultList = new ArrayList<>();
  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    dfs(nums,new boolean[nums.length],new ArrayList<>());
    return resultList;
  }

  private void dfs(int[] nums,boolean[] visit,List<Integer> example){
    if(example.size() == nums.length){
      //how to remove duplicate
      resultList.add(new ArrayList<>(example));
      return;
    }
    for(int i = 0;i < nums.length;i++){

      if(visit[i]) continue;
      if(i>0&&nums[i]==nums[i-1]&&!visit[i-1]) continue;
      example.add(nums[i]);
      visit[i] = true;
      dfs(nums,visit,example);
      example.remove(example.size() - 1);
      visit[i] = false;
    }
  }

}
