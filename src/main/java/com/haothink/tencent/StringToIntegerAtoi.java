package com.haothink.tencent;

/**
 * Created by wanghao on 2021/8/21
 *
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either.
 * This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically,
 * integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 *
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "42" ("42" is read in)
 *            ^
 * The parsed integer is 42.
 * Since 42 is in the range [-231, 231 - 1], the final result is 42.
 * 1. 若字符串开头是空格，则跳过所有空格，到第一个非空格字符，如果没有，则返回0.
 *
 * 2. 若第一个非空格字符是符号 +/-，则标记 sign 的真假，这道题还有个局限性，那就是在 c++ 里面，+-1 和-+1 都是认可的，都是 -1，而在此题里，则会返回0.
 *
 * 3. 若下一个字符不是数字，则返回0，完全不考虑小数点和自然数的情况，不过这样也好，起码省事了不少。
 *
 * 4. 如果下一个字符是数字，则转为整形存下来，若接下来再有非数字出现，则返回目前的结果。
 *
 * 5. 还需要考虑边界问题，如果超过了整型数的范围，则用边界值替代当前值。
 **/
public class StringToIntegerAtoi {


  public int myAtoi(String str) {

    if (str.isEmpty()) return 0;
    int sign = 1, base = 0, i = 0, n = str.length();
    while (i < n && str.charAt(i) == ' ') ++i;
    if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
      sign = (str.charAt(i++) == '+') ? 1 : -1;
    }
    while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
      if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
        return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      base = 10 * base + (str.charAt(i++) - '0');
    }
    return base * sign;
  }

}
