package com.haothink.baidu;

/**
 * Created by wanghao on 2021/10/6
 *
 * Given a non-empty array nums containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 * 回到本题，题目要求将一个数组的数分成两部分，并保证这两部分的和相同。这个条件很容易想到，既然两边和相同，
 * 那个这个和一定是该数组所有数的和除以2。接下来考虑，如果总和不能够被2整除的话，那么一定不会存在解，
 * 直接返回false即可。另外还有一种极端情况，即数组长度为0或者1的时候，我们也无法分割，故而也可直接返回false。
 *
 **/
public class PartitionEqualSubsetSum {


  public static void main(String[] args) {

    PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();

    int[] nums = {1,5,11,5};
    System.out.println(partitionEqualSubsetSum.canPartition(nums));

  }

  public boolean isCanPartition = false;

  //Time Limit Exceeded
  public boolean canPartition(int[] nums) {

    if(null == nums || nums.length <=1){
      return false;
    }
    //sum array
    // 计算出数组中所有数的和。
    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    // 如果总和不能被2整除，返回false。
    if (sum % 2 != 0) {
      return false;
    }
    int target = sum/2;

    dfs(nums,target,0,new boolean[nums.length]);

    return isCanPartition;
  }

  public void dfs(int[] nums,int target,int countNum,boolean[] visited){

    if(isCanPartition){
      return;
    }
    if(target == 0 && countNum < nums.length){
      isCanPartition = true;
      return;
    }
    for(int i=0;i<nums.length;i++){

      if(visited[i]){
        continue;
      }
      visited[i] = true;
      dfs(nums,target-nums[i],countNum+1,visited);
      visited[i] = false;
    }
  }
}
