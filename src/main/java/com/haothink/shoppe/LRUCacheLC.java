package com.haothink.shoppe;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by wanghao on 2021-07-01
 **/
public class LRUCacheLC {


  private final Map<Integer, Integer> map;
  private final LinkedList<Integer> queue;

  private final int capacity;


  public LRUCacheLC(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("capacity <= 0");
    }
    this.map = new LinkedHashMap<>();
    this.queue = new LinkedList<>();
    this.capacity = capacity;
  }

  public void put(int key, int value) {
    // 首先判断当前数据是否存在
    if (!map.containsKey(key)) {
      queue.addFirst(key);
    } else {
      // 如果是修改，则需要将其移动到头部
      moveToHead(key);
    }

    map.put(key, value);
    // 如果不存在，首先判断队列中是否已经满了
    if (queue.size() > capacity) {
      // 移除队列中最后一个结点
      map.remove(queue.removeLast());
    }
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      // 如果是修改，则需要将其移动到头部
      int value = map.get(key);
      moveToHead(key);
      return value;
    } else {
      return -1;
    }
  }

  private void moveToHead(int key) {
    queue.remove(key);
    queue.addFirst(key);
  }

}
