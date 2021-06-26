package com.haothink.leetcode.two_heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wanghao on 2021-06-26
 *
 * The median is the middle value in an ordered integer list. If the size of the list is even,
 * there is no middle value and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 **/
public class MedianFinder {


  public static void main(String[] args) {

  }


  private List<Integer> medianList = null;

  /** initialize your data structure here. */
  public MedianFinder() {

    medianList = new ArrayList<>();
  }

  public void addNum(int num) {

    medianList.add(num);
    Collections.sort(medianList);

  }

  public double findMedian() {

    if(medianList.size() % 2 == 0){
      //even
      int firstMedianValue = medianList.get(medianList.size()/2 -1);
      int secondMedianValue = medianList.get(medianList.size()/2);

      return (Double.valueOf(firstMedianValue+"") + Double.valueOf(secondMedianValue+""))/2;
    }else {
      //odd
      return medianList.get(medianList.size()/2);
    }
  }


}
