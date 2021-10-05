package com.haothink.kuaishou;

/**
 * Created by wanghao on 2021/10/5
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 * 递归，降幂，减少累乘次数
 * 1、n为0，返回1
 * 2、n为正偶数，如n=4，即2^4=2222，可以拆解为(22)^(n/2)
 * 3、n为正奇数，如n=3，即2^3=222，可以拆解为2*((22)^(n-1/2)) ，极端情况n=1 为 2(2^0)=2也是正确的
 * 4、n为负数，首先考虑到的是递归1/(myPow(x,-n))，但是n若为2^31-1时-n溢出，因此这里用-(n+1)计算，再额外乘以一次x即可
 *
 **/
public class PowxN {

  public double myPow(double x, int n) {

    if(n == 0) return 1.0;
    double half = myPow(x, n/2);
    if(n%2 == 0) {
      return half * half;
    }

    if(n > 0) {
      return half * half * x;
    }
    else {
      return  half * half / x;
    }
  }
}
