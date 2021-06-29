package com.haothink.shoppe;

/**
 * Created by wanghao on 2021-06-29
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 **/
public class FibonacciNumber {


  public static void main(String[] args) {

  }

  public int fib(int n) {

    if(n == 0){
      return 0;
    }
    if(n == 1){
      return 1;
    }

    return fib(n-1) + fib(n-2);
  }

  public int fib2(int n){

    if(n == 0){
      return 0;
    }
    if(n == 1){
      return 1;
    }

    int oneFb = 0;
    int twoFb = 1;
    int temp = -1;
    for(int i=2;i<=n;i++){
      temp = twoFb;
      twoFb = (oneFb + twoFb);
      oneFb = temp;

    }
    return twoFb;
  }
}
