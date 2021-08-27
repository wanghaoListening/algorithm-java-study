package com.haothink.microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021/8/27
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Input: n = 1
 * Output: ["()"]
 *
 * 对于这种列出所有结果的题首先还是考虑用递归 Recursion 来解，由于字符串只有左括号和右括号两种字符，而且最终结果必定是左括号3个，
 * 右括号3个，所以这里定义两个变量 left 和 right 分别表示剩余左右括号的个数，如果在某次递归时，左括号的个数大于右括号的个数，
 * 说明此时生成的字符串中右括号的个数大于左括号的个数，即会出现 ')(' 这样的非法串，所以这种情况直接返回，不继续处理。如果 left
 * 和 right 都为0，则说明此时生成的字符串已有3个左括号和3个右括号，且字符串合法，则存入结果中后返回。如果以上两种情况都不满足，
 * 若此时 left 大于0，则调用递归函数，注意参数的更新，若 right 大于0，则调用递归函数，同样要更新参数，
 **/
public class GenerateParentheses {


  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<String>();
    helper(n, n, "", res);
    return res;
  }
  private void helper(int left, int right, String out, List<String> res) {
    if (left < 0 || right < 0 || left > right) return;
    if (left == 0 && right == 0) {
      res.add(out);
      return;
    }
    helper(left - 1, right, out + "(", res);
    helper(left, right - 1, out + ")", res);
  }
}
