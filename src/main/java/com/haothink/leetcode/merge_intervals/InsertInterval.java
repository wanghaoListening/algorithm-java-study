package com.haothink.leetcode.merge_intervals;

import java.util.Arrays;

/**
 * Created by wanghao on 2021-04-05
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 *
 *
 * [[0,2],[3,3],[6,11]]
 * [9,15]
 **/
public class InsertInterval {

  public static void main(String[] args) {

    int[][] intervals = {{0,2},{3,3},{6,11}};

    int[] newInterval = {9,15};


    InsertInterval insertInterval = new InsertInterval();
    System.out.println(Arrays.toString(insertInterval.insert(intervals,newInterval)));

  }


  public int[][] insert(int[][] intervals, int[] newInterval) {

    //check corner case
    if(intervals.length == 0){

      return new int[][]{newInterval};
    }

    // init a new double array
    int[][] resultInterval = new int[intervals.length+newInterval.length][2];
    int pos = 0;
    //sign newInterval has been inserted
    boolean hasInserted = false;
    for(int i=0;i<intervals.length;i++){

      if(hasInserted){
        resultInterval[pos++] = intervals[i];
        continue;
      }

      if(newInterval[0] > intervals[i][1]){

        resultInterval[pos++] = intervals[i];
        if(i == intervals.length-1){
          resultInterval[pos++] = newInterval;
          hasInserted = true;
        }

      }else if(newInterval[1] < intervals[i][0]){

        if(!hasInserted) {
          resultInterval[pos++] = newInterval;
          hasInserted = true;
        }
        resultInterval[pos++] = intervals[i];

      }else if(newInterval[0] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) {

        resultInterval[pos++] = intervals[i];
        hasInserted = true;

      }else {
        newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
        if(i == intervals.length-1){
          resultInterval[pos++] = newInterval;
          hasInserted = true;
        }
      }
    }

    if(pos == 0){
      return new int[][]{newInterval};
    }

    int[][] finalResultInterval = new int[pos][2];

    for(int i=0;i<pos;i++){

      finalResultInterval[i] = resultInterval[i];
    }

    return finalResultInterval;
  }

}
