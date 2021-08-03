package com.haothink.shoppe;

/**
 * Created by wanghao on 2021/8/2 mail:hellotime@gmail.com
 *
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 *
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 * Input: columnNumber = 1
 * Output: "A"
 * Input: columnNumber = 28
 * Output: "AB"
 *
 **/
public class ExcelSheetColumnTitle {


  public static void main(String[] args) {

    System.out.println(2147483647);
  }

  public String convertToTitle(int columnNumber) {

    if (columnNumber <= 0) {
      return "";
    }
    if (columnNumber < 27) {
      return "" + (char) ('A' + columnNumber - 1);
    } else {
      if (columnNumber % 26 == 0) {
        return convertToTitle(columnNumber / 26 - 1) + "Z";
      } else {
        return convertToTitle(columnNumber / 26) + (char) ('A' + columnNumber % 26 - 1);
      }
    }
  }
}
