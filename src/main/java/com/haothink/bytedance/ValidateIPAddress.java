package com.haothink.bytedance;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by wanghao on 2021/9/10
 *
 * Given a string IP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.
 *
 * A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0"
 * are valid IPv4 addresses but "192.168.01.1", while "192.168.1.00" and "192.168@1.1" are invalid IPv4 addresses.
 *
 * A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:
 *
 * 1 <= xi.length <= 4
 * xi is a hexadecimal string which may contain digits, lower-case English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
 * Leading zeros are allowed in xi.
 * For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334" and
 * "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.
 *
 * Input: IP = "172.16.254.1"
 * Output: "IPv4"
 * Explanation: This is a valid IPv4 address, return "IPv4".
 *
 * Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * Output: "IPv6"
 * Explanation: This is a valid IPv6 address, return "IPv6".
 **/
public class ValidateIPAddress {

  public static void main(String[] args) {

    System.out.println(Arrays.toString("2001".toCharArray()));
    ValidateIPAddress validateIPAddress = new ValidateIPAddress();
    System.out.println(validateIPAddress.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
  }

  public String validIPAddress(String ip) {

    //check head and tail
    if(Objects.isNull(ip) || ip.length() == 0){
      return "Neither";
    }
    char head = ip.charAt(0);
    char tail = ip.charAt(ip.length()-1);
    if(!Character.isLetterOrDigit(head) || !Character.isLetterOrDigit(tail)){
      return "Neither";
    }
    String[] ipSegments = null;

    if(ip.contains(".")){
      ipSegments = ip.split("\\.");
    }else if(ip.contains(":")){
      ipSegments = ip.split(":");
    }else {
      return "Neither";
    }

    if(isValidIpv4(ipSegments)){

      return "IPv4";
    }else if(isValidIpv6(ipSegments)){
      return "IPv6";
    }else {
      return "Neither";
    }
  }

  public boolean isValidIpv4(String[] ipSegments){

    if(ipSegments.length !=4){
      return false;
    }

    for(int i=0;i<ipSegments.length;i++){
      int segment = 0;
      try {
        segment = Integer.parseInt(ipSegments[i]);
      }catch (Exception e){
        return false;
      }

      if(String.valueOf(segment).length() < ipSegments[i].length()){
        return false;
      }
      if(0 > segment || segment > 255){
        return false;
      }
    }
    return true;
  }

  public boolean isValidIpv6(String[] ipSegments){
    if(ipSegments.length !=8){
      return false;
    }
    for(int i=0;i<ipSegments.length;i++){

      if(ipSegments[i].length() > 4 || ipSegments[i].length() < 1){
        return false;
      }
      char[] chs = ipSegments[i].toCharArray();
      for(int j=0;j<chs.length;j++){
        //('a' to 'f')
        if(!Character.isDigit(chs[j]) && !(chs[j] >= 'a' && chs[j] <='f') && !(chs[j] >= 'A' && chs[j] <='F')){
          return false;
        }
      }
    }
    return true;
  }

}
