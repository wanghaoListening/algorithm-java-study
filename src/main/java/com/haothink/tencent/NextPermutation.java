package com.haothink.tencent;

import java.util.Arrays;

/**
 * Created by wanghao on 2021/8/21
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 *
 * The replacement must be in place and use only constant extra memory.
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 *
 * 给定一个数据排列，要求找出该组数据组成的下一个比原排列大的数据，如果这样的数据不存在（原排列已经是最大组合），则将数据按升序排列（最小组合），
 * 说得更直白一点：给你三个数1,2,3,这三个数能够构成的最小数为123，最大为321，给定其中一种组合如132，要求下一个比它大的组合，必须是下一个，
 * 显然这个数为：213.
 *
 * 这个题目本身不难，关键是理解题意，我们以一个例子来分析，给定325421，求其下一个比它大的数，怎么办呢？我们应该从最低位开始，
 * 1->2->4->5,这一段是升序的，也就是5421已经是最大数，不存在比它大的组合，我们继续找，1->2->4->5->2，出现降序这个位置就
 * 是我们要找的关键点，只需要将2与其后的数字中的（1,2,4,5）比它大的最小数，也就4替换，然后再将后面的数（1,2,2,5）升序排列
 * 便可得到下一个数，过程为：325421->345221->345122
 **/
public class NextPermutation {

  public static void main(String[] args) {

    int[] nums = {1,3,2};
    NextPermutation nextPermutation = new NextPermutation();
    nextPermutation.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
  }

  public void nextPermutation(int[] nums) {

    int endIndexOfAscend = 0;
    for(int i=nums.length-1;i>=1;i--){

      if(nums[i-1] < nums[i]){
        endIndexOfAscend = i;
        break;
      }
    }
    //直接升序排序
    if(endIndexOfAscend == 0){
      Arrays.sort(nums);
      return;
    }
    swap(nums,endIndexOfAscend);
    if(endIndexOfAscend == nums.length-1){
      return;
    }
    //从endIndexOfAscend后的索引进行升序排序
    int[] copyArray = Arrays.copyOfRange(nums,endIndexOfAscend,nums.length);
    Arrays.sort(copyArray);
    for(int i=0;i<copyArray.length;i++){
      nums[endIndexOfAscend+i] = copyArray[i];
    }
  }

  private void swap(int[] nums,int endIndexOfAscend){

    for(int i=nums.length-1;i>=endIndexOfAscend;i--){

      if(nums[i] > nums[endIndexOfAscend-1]){
        int temp = nums[i];
        nums[i] = nums[endIndexOfAscend-1];
        nums[endIndexOfAscend-1] = temp;
        break;
      }
    }
  }
}
