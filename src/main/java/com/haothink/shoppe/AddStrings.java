package com.haothink.shoppe;

/**
 * Created by wanghao on 2021-07-08
 *
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
 * You must also not convert the inputs to integers directly.
 *
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 **/
public class AddStrings {


  public static void main(String[] args) {


    String num1 = "1", num2 = "9";

    AddStrings addStrings = new AddStrings();
    System.out.println(addStrings.addStrings(num1,num2));
  }

  public String addStrings(String num1, String num2) {

    char[] chNum1 = num1.toCharArray();
    char[] chNum2 = num2.toCharArray();

    int indexOfNum1 = num1.length()-1;
    int indexOfNum2 = num2.length()-1;
    StringBuilder stringBuilder = new StringBuilder();
    int bitNum = 0;
    while (indexOfNum1 >= 0 || indexOfNum2 >=0){

      char digit1 = (indexOfNum1>=0)?chNum1[indexOfNum1]:'0';
      char digit2 = (indexOfNum2>=0)?chNum2[indexOfNum2]:'0';
      String sum = (Integer.parseInt(digit1+"") + Integer.parseInt(digit2+"") + bitNum)+"";
      char[] sumChar = sum.toCharArray();
      if(sumChar.length == 1){
        stringBuilder.append(sumChar[0]);
        bitNum = 0;
      }
      if(sumChar.length == 2){
        stringBuilder.append(sumChar[1]);
        bitNum = 1;
      }

      indexOfNum1--;
      indexOfNum2--;
    }
    if(bitNum==1){
      stringBuilder.append(1);
    }
    return stringBuilder.reverse().toString();
  }

}
