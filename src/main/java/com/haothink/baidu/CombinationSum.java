package com.haothink.baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wanghao on 2021/9/25
 *
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers
 * sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is
 * less than 150 combinations for the given input.
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 **/
public class CombinationSum {

  public static void main(String[] args) {
    int[] candidates = {2,3,6,7};
    int target = 7;
    CombinationSum combinationSum = new CombinationSum();
    System.out.println(combinationSum.combinationSum(candidates,target));
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> allList = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(candidates, 0, target, new ArrayList<>(), allList);
    return allList;
  }
  public void backtrack(int[] candidates, int from, int target, List<Integer> cur, List<List<Integer>> allList) {
    if(target == 0) {
      allList.add(new ArrayList<>(cur));
      return;
    }
    for(int i = from; i < candidates.length; ++i) {
      if(candidates[i] > target) {
        break;
      }
      cur.add(candidates[i]);
      backtrack(candidates, i, target-candidates[i], cur, allList);
      cur.remove(cur.size()-1);
    }
  }


}
