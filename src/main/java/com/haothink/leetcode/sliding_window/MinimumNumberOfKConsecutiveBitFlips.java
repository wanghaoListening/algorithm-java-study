package com.haothink.leetcode.sliding_window;

/**
 * Created by wanghao on 2021-03-20 mail:
 *
 * In an array A containing only 0s and 1s, a K-bit flip consists of choosing a (contiguous) subarray of length K and simultaneously changing every 0 in the subarray to 1, and every 1 in the subarray to 0.
 *
 * Return the minimum number of K-bit flips required so that there is no 0 in the array.  If it is not possible, return -1.
 *
 *
 * Input: A = [0,1,0], K = 1
 * Output: 2
 * Explanation: Flip A[0], then flip A[2].
 *
 * Input: A = [0,0,0,1,0,1,1,0], K = 3
 * Output: 3
 * Explanation:
 * Flip A[0],A[1],A[2]: A becomes [1,1,1,1,0,1,1,0]
 * Flip A[4],A[5],A[6]: A becomes [1,1,1,1,1,0,0,0]
 * Flip A[5],A[6],A[7]: A becomes [1,1,1,1,1,1,1,1]
 *
 * Solution: Greedy
 * From left most, if there is a 0, that bit must be flipped since the right ones won’t affect left ones.
 *
 * Time Limit Exceeded
 **/
public class MinimumNumberOfKConsecutiveBitFlips {


  public static void main(String[] args) {

    MinimumNumberOfKConsecutiveBitFlips numberOfKConsecutiveBitFlips = new MinimumNumberOfKConsecutiveBitFlips();
    int[] A = {1,1,0};
    int K = 2;
    System.out.println(numberOfKConsecutiveBitFlips.minKBitFlips(A,K));
  }

  public int minKBitFlips(int[] nums, int k) {

    int endIndex = 0;
    int count = 0;
    boolean flag = false;
    while (endIndex < nums.length){

      if(nums[endIndex] == 0){
        //
        if(endIndex+k > nums.length){
          return -1;
        }
        //flip it and the next k-1 bit
        count++;
        nums[endIndex] = 1;
        int i = endIndex+1;
        while (i < endIndex+k){
          nums[i] = nums[i] == 0?1:0;
          i++;
        }
        flag = true;
      }else {

        endIndex++;
      }
    }
    return flag?(count==0?-1:count):0;

  }
}
