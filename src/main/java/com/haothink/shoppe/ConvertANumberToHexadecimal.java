package com.haothink.shoppe;

/**
 * Created by wanghao on 2021-07-07
 *
 * Given an integer num, return a string representing its hexadecimal representation. For negative integers,
 * two’s complement method is used.
 *
 * All the letters in the answer string should be lowercase characters, and there should not be any leading
 * zeros in the answer except for the zero itself.
 *
 * Note: You are not allowed to use any built-in library method to directly solve this problem.
 *
 * Input: num = 26
 * Output: "1a"
 * 数字转化成16进制的规则
 **/
public class ConvertANumberToHexadecimal {


  public static void main(String[] args) {

  }

  public String toHex(int num) {


    if(num==0){
      return "0";
    }
    String hex="0123456789abcdef";
    StringBuilder ans=new StringBuilder();
    while(num!=0 && ans.length()<8){
      ans.append(hex.charAt(num & 0xf));
      num>>=4;
    }
    return  ans.reverse().toString();
  }

}
