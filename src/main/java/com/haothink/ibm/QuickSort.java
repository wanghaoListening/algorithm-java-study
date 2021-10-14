package com.haothink.ibm;

/**
 * Created by wanghao on 2021/10/13 mail:hiwanghao@didiglobal.com
 **/
public class QuickSort {





  // 4  - 6 7 3 2 5 6 10

  public void quickSort(int[] nums,int startIndex,int endIndex){

    if(startIndex >= endIndex){

      return;
    }
    int lowIndex = startIndex,highIndex = endIndex;
    int baseNum = nums[startIndex];

    while(startIndex < endIndex){

      while (nums[endIndex] >= baseNum && startIndex < endIndex){
        endIndex--;
      }
      while (nums[startIndex] <= baseNum && startIndex < endIndex){
        startIndex ++;
      }

      if(startIndex < endIndex){
        int temp = nums[endIndex];
        nums[endIndex] = nums[startIndex];
        nums[startIndex] = temp;
      }
    }

    //将基准位置的数值放到两个列表中点位置
    nums[lowIndex] = nums[startIndex];
    nums[startIndex] = baseNum;

    quickSort(nums,lowIndex,startIndex-1);
    quickSort(nums,startIndex+1,highIndex);
  }
}
