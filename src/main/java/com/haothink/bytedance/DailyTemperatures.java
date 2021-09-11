package com.haothink.bytedance;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by wanghao on 2021/9/11
 *
 * Given an array of integers temperatures represents the daily temperatures, return an array answer
 * such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 *
 **/
public class DailyTemperatures {


  public static void main(String[] args) {

    DailyTemperatures dailyTemperatures = new DailyTemperatures();
    int[] temperatures = {73,74,75,71,69,72,76,73};

    System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(temperatures)));

  }

  //1109 ms, faster than 10.86% of Java online submissions for Daily Temperatures.
  public int[] dailyTemperatures(int[] temperatures) {

    if(null == temperatures || temperatures.length == 0){
      return temperatures;
    }

    int[] result = new int[temperatures.length];

    for(int i=0;i<temperatures.length;i++){
      for(int j=i+1;j<temperatures.length;j++){
        if(temperatures[j] > temperatures[i]){
          result[i] = j-i;
          break;
        }
      }
    }
    return result;
  }


  //Runtime: 75 ms, faster than 19.19% of Java online submissions for Daily
  public int[] dailyTemperaturesStack(int[] T) {
    int[] result = new int[T.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = T.length - 1; i >= 0; i--) {
      /*若栈非空且栈顶对应那天温度T[stack.peek()] 小于等于 当天i的温度T[i]，则一直出栈，目的是找到比T[i]高的那天。若栈为空了，则T[i]是最高的温度*/
      while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        result[i] = stack.peek() - i;
      }
      stack.push(i);            //入栈
    }

    return result;
  }


}
