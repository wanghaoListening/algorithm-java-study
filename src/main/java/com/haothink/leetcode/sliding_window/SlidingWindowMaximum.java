package com.haothink.leetcode.sliding_window;


import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;



/**
 * Created by wanghao on 2021-03-17 mail:
 *
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of
 * the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right
 * by one position.
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * Time Limit Exceeded
 * 1.维护一个大小为K的最大堆，依此维护一个大小为K的窗口，每次读入一个新数，都把堆中窗口最左边的数扔掉，再把新数加入堆中，这样堆顶就是这个窗口内最大的值。
 *
 * O(N)
 * 2.使用双端队列，队列元素降序排序，队首元素为所求最大值。滑动窗口右移，若出现的元素比队首（最大元素）大，此时清空队列，并将最大值插入队列。若比当前值小，则插入尾部。每次窗口右移的时候需要判断当前的最大值是否在有效范围，若不在，则需要将其从队列中删除。
 *
 **/
public class SlidingWindowMaximum {


  public static void main(String[] args) {

    SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
    int[] nums = {1,3,-1,-3,5,3,6,7};
    int k = 3;
    int[] resultNums = slidingWindowMaximum.maxSlidingWindow(nums,k);
    System.out.println(Arrays.toString(resultNums));

  }
  public int[] maxSlidingWindow(int[] nums, int k) {

    if(k == 1){

      return nums;
    }
    int index = 0;
    int sizeOfResultNums = 0;
    int[] resultNums = new int[nums.length-k+1];
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    while (index < nums.length){

      if(pq.size() < k){
        //add value to heap
        pq.offer(nums[index]);
      }

      if(pq.size() >= k){
        //get value ,top of heap
        resultNums[sizeOfResultNums] = pq.peek();
        //remove vary left value
        pq.remove(nums[sizeOfResultNums]);
        sizeOfResultNums ++;
      }

      index ++;
    }
    return resultNums;
  }


}
