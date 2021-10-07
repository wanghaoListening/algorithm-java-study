package com.haothink.jerry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021/10/6 mail:wanghaotime@qq.com
 **/
public class RangeList {




  private List<int[]> rangeList = null;

  public RangeList(){

    rangeList = new ArrayList<>();
  }

  /**
   *
   * @param range
   *       {int[]} range - Array of two integers that specify beginning and end of range.
   */
  public void add(int[] range){

    if(rangeList.isEmpty() || rangeList.get(rangeList.size()-1)[1] < range[0]){
      rangeList.add(range);
      return;
    }

    //create new range list
    List<int[]> newRangeList = new ArrayList<>();
    // 1. [1   3)  [4   5)   2.[1   4)  [3   5)  3.[3   4)  [1   5)  4.[3   4)  [1   5)  5.[4   5)  [1   3) 6.[1   5)  [2   4)
    boolean rangeInserted = false;
    int index = 0;
    for(int[] currRange : rangeList){
      if(currRange[1] < range[0]){
        newRangeList.add(currRange);
      }else if(currRange[0] > range[1]){
        newRangeList.add(range);
        rangeInserted = true;
        for(int i=index;i<rangeList.size();i++) {
          newRangeList.add(rangeList.get(i));
        }
        break;
      }else {
        int left = Math.min(range[0],currRange[0]);
        int right = Math.max(range[1],currRange[1]);
        range = new int[]{left,right};
      }
      index++;
    }
    if(!rangeInserted){
      newRangeList.add(range);
    }
    rangeList = newRangeList;
  }

  /**
   *
   * @param range
   *        {int[]} range - Array of two integers that specify beginning and end of range.
   */
  public void remove(int[] range){
    //check
    if(rangeList.isEmpty()){
      return;
    }
    //remove range
    //create new range list
    List<int[]> newRangeList = new ArrayList<>();
    for(int[] currRange : rangeList){

      if(currRange[1] < range[0]){
        newRangeList.add(currRange);
      }else if(currRange[0] > range[1]){
        newRangeList.add(currRange);
      }else {
        //1. [1,5) [2,3)  2.[3,5) [1,4) 3.[3,5) [4,8)
        if(currRange[0] >= range[0] && currRange[1] <=range[1]){
          continue;
        }

        if(currRange[0] <= range[0] && currRange[1] >=range[1]){
          if(range[0] == range[1] && (range[0] == currRange[0] || range[0] == currRange[1])){
            newRangeList.add(new int[]{currRange[0],currRange[1]});
            continue;
          }
          if(range[0] == currRange[0]){
            newRangeList.add(new int[]{range[1],currRange[1]});
            continue;
          }
          if(range[1] == currRange[1]){
            newRangeList.add(new int[]{currRange[1],range[1]});
            continue;
          }
          newRangeList.add(new int[]{currRange[0],range[0]});
          newRangeList.add(new int[]{range[1],currRange[1]});
        }else if(range[0] <= currRange[0]){
          newRangeList.add(new int[]{range[1],currRange[1]});
        }else {
          newRangeList.add(new int[]{currRange[0],range[0]});
        }
      }
    }
    rangeList = newRangeList;
  }

  /**
   * Prints out the list of ranges in the range list
   */
  public void print(){

    String printFormatStr = "[%d, %d) ";

    for(int[] range : rangeList){
      System.out.printf(printFormatStr, range[0],range[1]);
    }
    System.out.println();
  }
}
