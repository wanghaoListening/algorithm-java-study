package com.haothink.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghao on 2021/10/14
 *
 * You are given a string s. We want to partition the string into as many parts as
 * possible so that each letter appears in at most one part.
 *
 * Return a list of integers representing the size of these parts.
 *
 * 将一个字符串分成几个部分，要保证每一部分的子字符串内的字符都不能在其他子字符串中出现。
 *
 * 先遍历一遍字符串，目的是将每种字符在字符串中最终出现的位置index记录下来。
 * 第二次遍历字符串，查看当前字符最终出现的位置index，此时，至少到这个index为止是不能分割的。
 * 继续循环下一个字符，看它的最终出现的index在哪，如果大小于前一个字符的最终index可以无视，
 * 如果大于的话说明到当前这个字符的最终index为止是不能被分割的，以此类推，直到当前index等于
 * 与之前记录的所有最终index的最大值相同时，说明此index之后再无之前的任何字符，此时可以分割。
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 **/
public class PartitionLabels {


  public static void main(String[] args) {

    String s = "ababcbacadefegdehijhklij";

    PartitionLabels partitionLabels = new PartitionLabels();

    System.out.println(partitionLabels.partitionLabels(s));
  }

  public List<Integer> partitionLabels(String s) {

    if(null == s || s.length()==0){

      return new ArrayList<>();
    }
    Map<Character,Integer> param = new HashMap<>();

    char[] chs = s.toCharArray();

    for (int i = 0; i <chs.length; i++) {
      param.put(chs[i],i);
    }

    List<Integer> partitionList = new ArrayList<>();
    int startIndex = 0;
    int endIndex = 0;
    int right = 0;
    while (endIndex < chs.length){

      right = Math.max(right,param.get(chs[endIndex]));
      if(param.get(chs[endIndex]) == endIndex && endIndex == right){
        partitionList.add(endIndex-startIndex+1);
        startIndex = endIndex+1;
      }
      endIndex++;
    }
    return partitionList;
  }
}
