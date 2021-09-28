package com.haothink.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021/9/28
 **/
public class RestoreIPAddresses {

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
