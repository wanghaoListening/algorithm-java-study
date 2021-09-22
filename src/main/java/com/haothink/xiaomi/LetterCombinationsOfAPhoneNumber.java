package com.haothink.xiaomi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021/9/22
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter
 * combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 **/
public class LetterCombinationsOfAPhoneNumber {

  public static void main(String[] args) {

    LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();

    System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("23"));
  }

  public static String[] phoneMapping = new String[] {"","","abc","def",
      "ghi","jkl","mno","pqrs","tuv","wxyz"};

  public List<String> letterCombinations(String digits) {

    List<String> results = new ArrayList<>();
    if(null == digits || digits.length() == 0){

      return results;
    }
    dfsBackTrack(digits,"",results);

    return results;
  }

  public void dfsBackTrack(String digits,String seq,List<String> results){

    if(null == digits || digits.length() == 0){
      results.add(seq);
      return;
    }

    int phoneMappingIndex = Character.getNumericValue(digits.charAt(0));
    char[] chs = phoneMapping[phoneMappingIndex].toCharArray();
    String subStr = digits.substring(1);
    for (char ch : chs) {
      dfsBackTrack(subStr, seq + ch, results);
    }
  }
}
