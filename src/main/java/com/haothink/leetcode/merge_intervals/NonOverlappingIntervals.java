package com.haothink.leetcode.merge_intervals;

import java.util.Arrays;

/**
 * Created by wanghao on 2021-04-05
 **/
public class NonOverlappingIntervals {


  public static void main(String[] args) {


    int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};

    NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();

    System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(intervals));
  }


  public int eraseOverlapIntervals(int[][] intervals) {


    if(intervals.length == 0){

      return 0;
    }

    Arrays.sort(intervals, (interval1, interval2) -> interval1[1] - interval2[1]);

    int count = 0;
    int boundaryNum = intervals[0][1];
    for(int i=1;i<intervals.length;i++){

      if(intervals[i][0] >= boundaryNum){
        boundaryNum = intervals[i][1];
      }else {
        count++;
      }
    }
    return count;
  }



}
