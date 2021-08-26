package com.haothink.microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021/8/26
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 **/
public class Permutations {

  public static void main(String[] args) {

    Permutations permutations = new Permutations();

    int[] nums = {1,2,3};
    List<List<Integer>> lists = permutations.permute(nums);
    System.out.println(lists);
  }

  List<List<Integer>> result = new ArrayList<>();
  public List<List<Integer>> permute(int[] nums) {

    dfs(nums,new boolean[nums.length],new ArrayList<>());
    return result;
  }

  private void dfs(int[] nums,boolean[] visit,List<Integer> example){
    if(example.size() == nums.length){
      result.add(new ArrayList<>(example));
      return;
    }

    for(int i = 0;i < nums.length;i++){
      if(!visit[i]){
        example.add(nums[i]);
        visit[i] = true;
        dfs(nums,visit,example);
        example.remove(example.size() - 1);
        visit[i] = false;
      }
    }
  }

}
