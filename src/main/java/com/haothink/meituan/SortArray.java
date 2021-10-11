package com.haothink.meituan;

import java.util.Arrays;

/**
 * Created by wanghao on 2021/10/11
 *
 * 对一个整型数组中的数字进行分类排序：使得负数都靠左端，正数都靠右端，0在中部。注意问题的特点是：
 * 负数区域和正数区域内并不要求有序。可以利用这个特点通过1次线性扫描就结束战斗。
 *
 *
 **/
public class SortArray {

  public static void main(String[] args) {

    Integer[] num = {5, -3, 0, -18, 1, 2, 0};
    Arrays.sort(num, (a, b) -> Integer.signum(a) - Integer.signum(b));
    System.out.println(Arrays.toString(num)); // [-3, -18, 0, 0, 5, 1, 2]
  }
}
