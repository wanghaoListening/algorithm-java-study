package com.haothink.tencent;

/**
 * Created by wanghao on 2021/8/11
 *
 * Given the API rand7() that generates a uniform random integer in the range [1, 7], write a function rand10() that generates a uniform random integer in the range [1, 10].
 * You can only call the API rand7(), and you shouldn't call any other API. Please do not use a language's built-in random API.
 *
 * Each test case will have one internal argument n, the number of times that your implemented function rand10() will be called while testing. Note that this is not an
 * argument passed to rand10().
 *
 * Follow up:
 *
 * What is the expected value for the number of calls to rand7() function?
 * Could you minimize the number of calls to rand7()?
 *
 **/
public class ImplementRand10UsingRand7 {



  public int rand10() {

    int num = (rand7() - 1) * 7 + rand7();
    return (num <= 40) ? (num % 10 + 1) : rand10();
  }



  public int rand7(){
    return 0;
  }
}
