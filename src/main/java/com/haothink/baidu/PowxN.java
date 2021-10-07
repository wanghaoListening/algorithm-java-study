package com.haothink.baidu;

/**
 * Created by wanghao on 2021/10/7
 **/
public class PowxN {

  public double myPow(double x, int n) {


    if(n == 0){

      return 1.0;
    }

    double half = myPow(x,n/2);

    if(n %2 == 0){
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
