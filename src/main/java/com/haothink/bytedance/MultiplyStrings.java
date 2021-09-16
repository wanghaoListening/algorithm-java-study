package com.haothink.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021/9/16
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product
 * of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * 乘法的原理大家都懂，本题只是还原一下我们口算的过程而已。比如123乘以456，实际上我们可以看做 6*123+5*1230+4*12300。
 *
 * 竖式乘法
 * 对于例子中的123 * 456，我们可以通过得到:
 * 3 * 456 + 20 * 456 + 100 *456 = 1368 + 9120 + 45600 = 56088
 *
 * 123456789
 * 987654321
 *
 **/
public class MultiplyStrings {


  public static void main(String[] args) {

    //MultiplyStrings multiplyStrings = new MultiplyStrings();

    //System.out.println(multiplyStrings.multiply("123456789","987654321"));



  }

  public String multiply(String num1, String num2) {
    if("0".equals(num1)||"0".equals(num2)) return "0";
    List<String> list=new ArrayList<>();
    for(int i=num1.length()-1;i>=0;i--){
      int n1=num1.charAt(i)-'0';
      if(n1==0) {
        num2+="0";
        continue;
      }
      int carry=0;
      StringBuilder sb=new StringBuilder();
      for(int j=num2.length()-1;j>=0;j--){
        int n2=num2.charAt(j)-'0';
        int mul=n1*n2;
        int num=(mul+carry)%10;
        sb.append(num);
        carry=(mul+carry)/10;
      }
      if(carry!=0) sb.append(carry);
      list.add(sb.reverse().toString());
      num2+="0";
    }
    return sum(list);
  }
  String sum(List<String> list){
    String num1=list.get(0);
    for(int i=1;i<list.size();i++){
      StringBuilder sb=new StringBuilder();
      String num2=list.get(i);
      int i1=num1.length()-1;
      int i2=num2.length()-1;
      int carry=0;
      while(i1>=0||i2>=0){
        int n1=i1>=0?num1.charAt(i1)-'0':0;
        int n2=i2>=0?num2.charAt(i2)-'0':0;
        int num=(n1+n2+carry)%10;
        sb.append(num);
        carry=(n1+n2+carry)/10;
        i1--;
        i2--;
      }
      if(carry!=0) sb.append(carry);
      num1=sb.reverse().toString();
    }
    return num1;
  }

}
