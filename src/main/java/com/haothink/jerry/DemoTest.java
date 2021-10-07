package com.haothink.jerry;

/**
 * Created by wanghao on 2021/10/6 mail:hiwanghao@didiglobal.com
 **/
public class DemoTest {

  public static void main(String[] args) {

    RangeList rangeList = new RangeList();
    rangeList.add(new int[]{1,5});
    rangeList.print();
    // Should display: [1, 5)

    rangeList.add(new int[]{10,20});
    rangeList.print();
    // Should display: [1, 5) [10, 20)

    rangeList.add(new int[]{20,20});
    rangeList.print();
    // Should display: [1, 5) [10, 20)

    rangeList.add(new int[]{20, 21});
    rangeList.print();
    // Should display: [1, 5) [10, 21)

    rangeList.add(new int[]{2, 4});
    rangeList.print();
    // Should display: [1, 5) [10, 21)

    rangeList.add(new int[]{3, 8});
    rangeList.print();
    // Should display: [1, 8) [10, 21)

    rangeList.remove(new int[]{10, 10});
    rangeList.print();
    // Should display: [1, 8) [10, 21)

    rangeList.remove(new int[]{10, 11});
    rangeList.print();
    // Should display: [1, 8) [11, 21)

    rangeList.remove(new int[]{15, 17});
    rangeList.print();
    // Should display: [1, 8) [11, 15) [17, 21)

    rangeList.remove(new int[]{3, 19});
    rangeList.print();
    // Should display: [1, 3) [19, 21)
  }
}
