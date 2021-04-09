package com.haothink.leetcode.merge_intervals;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by wanghao on 2021-04-05
 *
 * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter
 * represents a different task. Tasks could be done in any order. Each task is done in one unit
 * of time. For each unit of time, the CPU could complete either one task or just be idle.
 *
 * However, there is a non-negative integer n that represents the cooldown period between two
 * same tasks (the same letter in the array), that is that there must be at least n units of
 * time between any two same tasks.
 *
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 * AAAABBBEEFFGG 3
 *
 * A出现了4次，最多，mx=4，那么可以分为mx-1=3块，如下：
 * A---A---A---
 * 每块有n+1=4个，最后还要加上末尾的一个A，也就是25-24=1个任务，最终结果为13：
 * ABEFABEGABFGA
 **/
public class TaskScheduler {

  public static void main(String[] args) {


    TaskScheduler taskScheduler = new TaskScheduler();

    char[] tasks = {'A','A','A','B','B','B','C','C','C','D','D','E'};
    int n = 2;
    System.out.println(taskScheduler.leastInterval(tasks,n));

  }

  public int leastInterval(char[] tasks, int n) {


    //statistic numbers of same task
    Map<Character,Integer> charMap = new HashMap<>();

    for(int i=0;i<tasks.length;i++){

      if(charMap.containsKey(tasks[i])){

        charMap.put(tasks[i],charMap.get(tasks[i])+1);
      }else {

        charMap.put(tasks[i],1);
      }
    }
    int maxNum = 0;
    int m = 0;
    for (Map.Entry<Character,Integer> entry : charMap.entrySet()){

      if(entry.getValue() > maxNum){

        maxNum = entry.getValue();
        m = 1;
      }else if(entry.getValue() == maxNum){
        m ++;
      }
    }

    int len = (maxNum-1)*(n+1)+m;

    return Math.max(len,tasks.length);
  }

}
