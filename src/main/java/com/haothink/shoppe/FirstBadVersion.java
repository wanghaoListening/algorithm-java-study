package com.haothink.shoppe;

/**
 * Created by wanghao on 2021-07-06
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version
 * of your product fails the quality check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
 * ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the
 * first bad version. You should minimize the number of calls to the API.
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 *
 *
 * Time Limit Exceeded
 *
 **/
public class FirstBadVersion {

  public static void main(String[] args) {


  }

  public int firstBadVersion(int n) {

    int start = 1;
    int end = n;
    int middle = (start + end)/2;
    while (start <= end){

      boolean isBadVersion = isBadVersion(middle);
      if(isBadVersion && (!isBadVersion(middle-1))){

        return middle;
      }else if(!isBadVersion){
        start = middle +1;

      }else {
        end = middle -1;
      }
      middle = (start + end)/2;
    }
    return middle;
  }

  boolean isBadVersion(int version){

    return true;
  }
}
