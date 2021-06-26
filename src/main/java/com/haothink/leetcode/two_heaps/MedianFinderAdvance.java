package com.haothink.leetcode.two_heaps;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Created by wanghao on 2021-06-26
 *
 * 本解法要使用到两个PriorityQueue。原则上只要我们能将所有数字分成2组，2组的元素个数最多相差为1，并且保证其中一组元素中的数字都大于等于另外一组元素，那么我们很容易在两组数中找到符合条件的中位数。
 *
 * 解题时，建立两个 PriorityQueue 定义为smallHalf和largeHalf，分别代表较小的一半数字与较大的另一半数字。其中smallHalf设定为降序排列，largeHalf为升序排列，插入数据时，当 smallHalf 与
 * largeHalf 的元素个数相同时，我们向 smallHalf 插入当前数字，插入后，由于要保证 smallHalf 中的元素都小于等于 largeHalf 中的元素，所以我们需要将 smallHalf 中最大的一个元素移动到 largeHalf 中。
 *
 * 当 smallHalf 与 largeHalf 的元素个数不同时，我们向 largeHalf 插入当前元素，同时还需要将 largeHalf 中最小的元素移动到 smallHalf 中。
 *
 * findMedian方法中，判断 smallHalf 与 largeHalf 的元素个数是否相同，相同时，从 smallHalf 取一个最大值，并从 largeHalf 取一个最小值，求平均数返回即可。如果 smallHalf 的元素个数大于 largeHalf，
 * 直接返回 smallHalf 中最大元素，反之返回 largeHalf 中最小元素。
 **/
public class MedianFinderAdvance {


  private PriorityQueue<Integer> smallHalf = new PriorityQueue<>((a,b)->b-a);
  private PriorityQueue<Integer> largeHalf = new PriorityQueue<>();
  /** initialize your data structure here. */
  public MedianFinderAdvance() {

  }

  public void addNum(int num) {
    if(smallHalf.size()==largeHalf.size()){
      smallHalf.offer(num);
      Integer top = smallHalf.poll();
      if(Objects.nonNull(top)) {
        largeHalf.offer(top);
      }
    }else{
      largeHalf.offer(num);
      Integer bottom = largeHalf.poll();
      if(Objects.nonNull(bottom)) {
        smallHalf.offer(bottom);
      }
    }
  }

  public double findMedian() {
    if(smallHalf.size()==largeHalf.size()){
      return (smallHalf.peek()+largeHalf.peek())/2.0;
    }else if(smallHalf.size()>largeHalf.size()){
      return smallHalf.peek();
    }else{
      return largeHalf.peek();
    }
  }
}
