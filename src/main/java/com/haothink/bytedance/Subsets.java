package com.haothink.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021/9/6
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 **/
public class Subsets {

  public static void main(String[] args) {

    Subsets subsets = new Subsets();

    int[] nums = {1,2,3};
    System.out.println(subsets.subsets(nums));

  }

  public List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> subsets = new ArrayList<>();
    dfs(nums,new boolean[nums.length],subsets,new ArrayList<>(),0);
    return subsets;
  }

  public void dfs(int[] nums,boolean[] visited,List<List<Integer>> subsets,List<Integer> subset,int start){


    subsets.add(subset);

    for(int i=start;i<nums.length;i++){
      if(visited[i]){
        continue;
      }
      visited[i] = true;
      List<Integer> newSubset = new ArrayList<>(subset);
      newSubset.add(nums[i]);
      dfs(nums,visited,subsets,newSubset,i+1);
      visited[i] = false;
    }
  }
}
