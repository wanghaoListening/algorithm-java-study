package com.haothink.shoppe;

/**
 * Created by wanghao on 2021/7/22
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated, and only the integer
 * part of the result is returned.
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 *
 * Input: x = 4
 * Output: 2
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 * x的平方根就是要找到满足 k^2 ≤ x
 * k的最大值
 **/
public class SqrtxProblem {

  public static void main(String[] args) {

    SqrtxProblem sqrtxProblem = new SqrtxProblem();

    System.out.println(sqrtxProblem.mySqrt(8));

  }

  public int mySqrt(int x) {
    int k = 0;
    int start = 1;
    int end = x;
    while (start <= end){
      int mid = (start + end)/2;
      if(mid == k){
        return k;
      }
      int res = mid * mid;
      if(res == x){
        return mid;
      }else if(res > x){
        end = mid;
      }else {
        if(mid > k){
          k = mid;
        }
        start = mid;
      }
    }
    return k;
  }

}
