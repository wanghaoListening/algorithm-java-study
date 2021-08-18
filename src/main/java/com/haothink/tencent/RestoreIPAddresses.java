package com.haothink.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021/8/16 mail:hiwanghao@didiglobal.com
 *
 * Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.
 *
 * A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have
 * leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1"
 * are invalid IP addresses.
 *
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 *
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 *
 * 一是只要遇到字符串的子序列或配准问题首先考虑动态规划DP，二是只要遇到需要求出所有可能情况首先考虑用递归。
 * 基本思路：
 * a. 每次从前面取1到3个字符，看看是否合法，
 * b. 如果合法的话，对后面的进行递归
 * c. 递归完成后reset状态
 * d. 递归到有4个字符被取出来以后的话， 开始判断递归退出的条件
 *
 * 这里稍微有一点tricky的是什么是合法的ip地址， 我开始认为每段0-255都是合法的， 结果如果有一段是010的话被判断也是非法的，
 * 就是如果有两位或者三位的话，不能是用0开头的。 这类问题如果面试中遇到的话可以先确定需求，通常不会影响结果反而会有加分，就是
 * 会先确认需求然后再实现，因为在实际软件开发过程中也经常遇到这样的模糊不清的需求。当然，前提是代码写对了。
 **/
public class RestoreIPAddresses {

  public static void main(String[] args) {

    RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
    String s = "0279245587303";
    System.out.println(restoreIPAddresses.restoreIpAddresses(s));
  }

  public List<List<String>> ipList = new ArrayList<>();

  public List<String> restoreIpAddresses(String s) {

    List<String> result = new ArrayList<>();
    if(Objects.isNull(s) || s.length() > 12){
      return result;
    }
    checkIpAddress(s,1,new ArrayList<>());
    for(List<String> stringList:ipList){
      result.add(constructIpByList(stringList));
    }
    return result;
  }

  private String constructIpByList(List<String> ipGroup){

    StringBuilder stringBuilder = new StringBuilder();

    for(String segment:ipGroup){
      stringBuilder.append(segment);
      stringBuilder.append(".");
    }
    return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
  }

  private void checkIpAddress(String segmentStr,int group,List<String> ipGroup){

    if(4 == group && isValid(segmentStr)){
      ipGroup.add(segmentStr);
      ipList.add(ipGroup);
      return;
    }

    if(segmentStr.length() >=1 && isValid(segmentStr.substring(0,1))){
      List<String> newIPGroup = new ArrayList<>(ipGroup);
      newIPGroup.add(segmentStr.substring(0,1));
      checkIpAddress(segmentStr.substring(1),group+1,newIPGroup);
    }
    if(segmentStr.length() >=2 && isValid(segmentStr.substring(0,2))){
      List<String> newIPGroup = new ArrayList<>(ipGroup);
      newIPGroup.add(segmentStr.substring(0,2));
      checkIpAddress(segmentStr.substring(2),group+1,newIPGroup);
    }
    if(segmentStr.length() >=3 && isValid(segmentStr.substring(0,3))){
      List<String> newIPGroup = new ArrayList<>(ipGroup);
      newIPGroup.add(segmentStr.substring(0,3));
      checkIpAddress(segmentStr.substring(3),group+1,newIPGroup);
    }
  }

  public boolean isValid(String s){

    int length = s.length();
    if(length <= 0 || length > 3){
      return false;
    }
    if(length > 1 && s.startsWith("0")){
      return false;
    }
    int num = Integer.parseInt(s);
    return num >= 0 && num <= 255;
  }
}
