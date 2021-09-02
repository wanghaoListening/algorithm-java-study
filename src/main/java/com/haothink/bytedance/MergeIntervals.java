package com.haothink.bytedance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by wanghao on 2021/9/1
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 **/
public class MergeIntervals {

  public static void main(String[] args) {

    MergeIntervals mergeIntervals = new MergeIntervals();
    int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
    mergeIntervals.merge(intervals);
  }

  public int[][] merge(int[][] intervals) {

    if(null == intervals || intervals.length == 0){
      return new int[][]{};
    }
    Set<IntervalNode> treeSet = new TreeSet<>(new Comparator<IntervalNode>() {
      @Override
      public int compare(IntervalNode o1, IntervalNode o2) {
        if(o1.startNum == o2.startNum){
          return o1.endNum - o2.endNum;
        }else {
          return o1.startNum - o2.startNum;
        }
      }
    });
    for(int i=0;i<intervals.length;i++){
      treeSet.add(new IntervalNode(intervals[i][0],intervals[i][1]));
    }
    LinkedList<IntervalNode> intervalNodeList = new LinkedList<>();
    for(IntervalNode intervalNode : treeSet){
      if(intervalNodeList.isEmpty()){
        intervalNodeList.offerLast(intervalNode);
      }else {
        IntervalNode lastIntervalNode = intervalNodeList.getLast();
        if(intervalNode.endNum > lastIntervalNode.endNum && intervalNode.startNum <= lastIntervalNode.endNum){
          lastIntervalNode = intervalNodeList.removeLast();
          lastIntervalNode.endNum = intervalNode.endNum;
          intervalNodeList.offerLast(lastIntervalNode);
        }else if(intervalNode.startNum > lastIntervalNode.endNum){
          intervalNodeList.offerLast(intervalNode);
        }
      }
    }
    int[][] results = new int[intervalNodeList.size()][2];
    for(int i=0;i<intervalNodeList.size();i++){
      results[i] = new int[]{intervalNodeList.get(i).startNum, intervalNodeList.get(i).endNum};
    }
    return results;
  }


  private static class IntervalNode{

    public IntervalNode(int startNum, int endNum) {
      this.startNum = startNum;
      this.endNum = endNum;
    }
    public int startNum;
    public int endNum;
  }


}
