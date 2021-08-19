package com.haothink.tencent;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Created by wanghao on 2021/8/18
 *
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 *
 * Implement the LFUCache class:
 *
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and
 * remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
 * To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.
 *
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.
 *
 * The functions get and put must each run in O(1) average time complexity.
 *
 * Input
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 *
 * Explanation
 * // cnt(x) = the use counter for key x
 * // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // return 1
 *                  // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
 *                  // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // return -1 (not found)
 * lfu.get(3);      // return 3
 *                  // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
 *                  // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // return -1 (not found)
 * lfu.get(3);      // return 3
 *                  // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // return 4
 *                  // cache=[3,4], cnt(4)=2, cnt(3)=3
 *
 * LRU算法是首先淘汰最长时间未被使用的页面，而LFU是先淘汰一定时间内被访问次数最少的页面。
 **/
public class LFUCache {

  private Map<Integer,Integer> keyValueMap = null;
  private Map<Integer,Integer> keyCountMap = null;
  private Map<Integer, LinkedHashSet<Integer>> linkedHashSetMap = null;

  private int capacity;

  private int min;


  public LFUCache(int capacity) {
    //capacity*2 防止扩容带来的性能损耗
    keyValueMap = new HashMap<>(capacity*2);
    keyCountMap = new HashMap<>(capacity*2);
    linkedHashSetMap = new HashMap<>(capacity);
    this.capacity = capacity;
    this.min = 0;
  }

  public int get(int key) {

    if(!keyValueMap.containsKey(key)){
      return -1;
    }
    update(key);
    return keyValueMap.get(key);
  }

  private void update(int key) {
    int count = keyCountMap.get(key);
    keyCountMap.put(key,count+1);
    linkedHashSetMap.get(count).remove(key);
    if(count == min && linkedHashSetMap.get(count).size() == 0)
      min++;
    addToList(count+1,key);

  }

  public void put(int key, int value) {

    if(keyValueMap.containsKey(key)){
      keyValueMap.put(key,value);
      update(key);
      return;
    }

    if(keyValueMap.size() >= capacity){
      evict();
    }
    keyValueMap.put(key,value);
    keyCountMap.put(key,1);
    addToList(1,key);
    min = 1;
  }

  private void evict() {
    int key = linkedHashSetMap.get(min).iterator().next();
    linkedHashSetMap.get(min).remove(key);
    keyValueMap.remove(key);
    keyCountMap.remove(key);
  }

  private void addToList(int cnt, int key) {
    if(!linkedHashSetMap.containsKey(cnt)) {
      LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
      linkedHashSet.add(key);
      linkedHashSetMap.put(cnt, linkedHashSet);
    }
    linkedHashSetMap.get(cnt).add(key);
  }


  public static void main(String[] args) {


  }

}
