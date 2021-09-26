package com.haothink.baidu;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by wanghao on 2021/9/26
 *
 * You are given an array of positive integers w where w[i] describes the weight of ith index (0-indexed).
 *
 * We need to call the function pickIndex() which randomly returns an integer in the range [0, w.length - 1].
 * pickIndex() should return the integer proportional to its weight in the w array. For example, for w = [1, 3],
 * the probability of picking the index 0 is 1 / (1 + 3) = 0.25 (i.e 25%) while the probability of picking the
 * index 1 is 3 / (1 + 3) = 0.75 (i.e 75%).
 *
 * More formally, the probability of picking index i is w[i] / sum(w).
 *
 * Input
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output
 * [null,0]
 *
 * Explanation
 * Solution solution = new Solution([1]);
 * solution.pickIndex(); // return 0. Since there is only one single element on the array the
 * only option is to return the first element.
 *
 * Input
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output
 * [null,1,1,1,1,0]
 *
 **/
public class RandomPickWithWeight {

  Random random;
  int[] randomNumRangeArray = null;
  public RandomPickWithWeight(int[] w) {
    random = new Random();
    randomNumRangeArray = new int[w.length];
    int sum = 0;
    for(int i=0;i<w.length;i++){
      sum+=w[i];
      randomNumRangeArray[i] = sum;
    }
  }

  public int pickIndex() {

    int guess = random.nextInt(randomNumRangeArray[randomNumRangeArray.length-1])+1;
    int pos = Arrays.binarySearch(randomNumRangeArray,guess);
    if(pos < 0) {
      pos = -(pos+1);
    }
    return pos;
  }
}
