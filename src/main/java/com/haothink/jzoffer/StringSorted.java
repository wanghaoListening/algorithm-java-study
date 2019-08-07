package com.haothink.jzoffer;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年08月07日 15:35
 * description: 字符串的排列
 *
 * 题目描述：
 * 输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串abc，则打印出由字符a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 *
 * 解题思路：
 * 可以将字符串划分成两部分，首字符和后面的字符串,求所有可能出现在第一个位置的字符，即把首字符和后面的字符交换。
 *
 */
public class StringSorted {


    public static void main(String[] args) {
        String str = "abc";
        permutation(str);
    }


    private static void permutation(String str){
        if(Objects.isNull(str) || str.length() == 0){
            return;
        }
        char[] chs = str.toCharArray();
        printStrArrange(chs,0);
    }

    private static void printStrArrange(char[] chs,int offset){
        if(offset == chs.length-1){
            return;
        }
        if(offset == 0){
            System.out.println(chs);
        }
        int count = 1;
        for(int i=offset;i<chs.length;i++){

            char temp = chs[i];
            chs[i] = chs[offset];
            chs[offset] = temp;
            printStrArrange(chs,offset+1);
            //之所以count>1才输出，是因为,递归进入下一层时进行重复打印上一层的字符串序列
            if(count >1) {
                System.out.println(chs);
            }
            count ++;
            //将位置重制
            temp = chs[i];
            chs[i] = chs[offset];
            chs[offset] = temp;
        }

    }

}
