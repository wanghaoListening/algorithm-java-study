package com.haothink.kuaishou;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021/10/5
 *
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return the nth ugly number.
 *
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 *
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 *
 * 说法一（ugly number）：把只包含质因子2，3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但7、14不是，因为它们包含质因子7。
 * 习惯上我们把1当做是第一个丑数。
 *
 * 所有的 ugly number 都是由 1 开始，乘以 2/3/5 生成的。
 * 只要将这些生成的数排序即可获得，自动排序可以使用 set
 * 这样每次取出的第一个元素就是最小元素，由此再继续生成新的ugly number.
 *
 *
 **/
public class UglyNumberII {

  public int nthUglyNumber(int n) {

    List<Integer> oneList = new ArrayList<>();
    List<Integer> twoList = new ArrayList<>();
    List<Integer> threeList = new ArrayList<>();
    oneList.add(1);
    twoList.add(1);
    threeList.add(1);
    int temp = 0;

    for(int i=1;i<=n;i++){

      temp = Math.min(Math.min(oneList.get(0), twoList.get(0)), threeList.get(0));

      if(temp == oneList.get(0)) oneList.remove(0);
      if(temp == twoList.get(0)) twoList.remove(0);
      if(temp == threeList.get(0)) threeList.remove(0);

      oneList.add(temp*2);
      twoList.add(temp*3);
      threeList.add(temp*5);
    }
    return temp;
  }


}
