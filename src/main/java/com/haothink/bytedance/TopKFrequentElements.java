package com.haothink.bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Created by wanghao on 2021/10/19
 *
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 **/
public class TopKFrequentElements {

  public int[] topKFrequent(int[] nums, int k) {

    Map<Integer,Integer> frequentMap = new HashMap<>();

    for(int num : nums){

      if(frequentMap.containsKey(num)){
        frequentMap.put(num,frequentMap.get(num)+1);
      }else {
        frequentMap.put(num,1);
      }
    }

    //对map当中的key 按照出现频率进行排序
    PriorityQueue<Entry<Integer,Integer>> priorityQueue=
        new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
    for(Map.Entry<Integer,Integer> e : frequentMap.entrySet()){
      priorityQueue.offer(e);
    }

    int[] result = new int[k];
    for(int i=0;i<k;i++){

      result[i] = priorityQueue.poll().getKey();
    }

    return result;
  }
}
