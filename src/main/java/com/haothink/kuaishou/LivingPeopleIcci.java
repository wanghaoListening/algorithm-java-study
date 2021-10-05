package com.haothink.kuaishou;

/**
 * Created by wanghao on 2021/10/4
 *
 * 给定 N 个人的出生年份和死亡年份，第 i 个人的出生年份为 birth[i]，死亡年份为 death[i]，实现一个方法以计算生存人数最多的年份。
 *
 * 你可以假设所有人都出生于 1900 年至 2000 年（含 1900 和 2000 ）之间。如果一个人在某一年的任意时期处于生存状态，
 * 那么他应该被纳入那一年的统计中。例如，生于 1908 年、死于 1909 年的人应当被列入 1908 年和 1909 年的计数。
 *
 * 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份
 *
 * 输入：
 * birth = {1900, 1901, 1950}
 * death = {1948, 1951, 2000}
 * 输出： 1901
 *
 **/
public class LivingPeopleIcci {


  public static void main(String[] args) {
    int[] birth = {1900, 1901, 1950};
    int[] death = {1948, 1951, 2000};

    System.out.println(LivingPeopleIcci.maxAliveYear(birth,death));
  }

  public static int maxAliveYear(int[] birth, int[] death) {


    // 先统计每年的人口数变化
    int[] change = new int[102];
    for (int i = 0; i < birth.length; i++) {
      // eg:1900年出生的人导致1900年变化人数加1，存储在change[0]
      change[birth[i] - 1900]++;
      // eg:1900年死亡的人导致1901年变化人数减1，存储在change[1]
      change[death[i] - 1899]--;
    }
    int maxAlive = 0;
    int curAlive = 0;
    int theYear = 1900;
    // 再根据每年变化人数求一个最大值
    for (int i = 0; i < 101; i++) {
      curAlive += change[i];
      if (curAlive > maxAlive) {
        maxAlive = curAlive;
        theYear = 1900 + i;
      }
    }
    return theYear;

  }
}
