package com.haothink.shoppe;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wanghao on 2021/8/4
 *
 * The n numbers of 0,1,n-1 are arranged in a circle, starting from the number 0, each time the mth number is deleted from this circle.
 * Find the last number remaining in the circle.
 *
 * For example, the 5 numbers 0, 1, 2, 3, and 4 form a circle. Each time the third number is deleted from the number 0, the first 4 numbers
 * to be deleted are 2, 0, 4, and 1, so at the end The remaining number is 3.
 *
 * enter: n = 5, m = 3
 *  Output: 3
 *
 * enter: n = 10, m = 17
 *  Output: 2
 *
 **/
public class TheLastRemainingNumberInTheCircle {


  public static void main(String[] args) {

  }


  public int lastRemaining(int n, int m) {
    if (n < 1 || m < 1) {
      return -1;
    }
    List<Integer> list = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      list.add(i);
    }
    // 要删除元素的位置
    int idx = 0;
    // 开始计数的位置
    int start = 0;
    while (list.size() > 1) {
      // 只要移动m-1次就可以移动到下一个要删除的元素上
      for (int i = 1; i < m; i++) {
        idx = (idx + 1) % list.size(); // 【A】
      }
      list.remove(idx);
      // 确保idx指向每一轮的第一个位置
      // 下面的可以不用，【A】已经可以保证其正确性了，可以分析n=6，m=6的第一次删除情况
      //  if (idx == list.size()) {
      //      idx = 0;
      //  }
    }
    return list.get(0);
  }
}
