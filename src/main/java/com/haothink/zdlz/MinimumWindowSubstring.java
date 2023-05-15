package com.haothink.zdlz;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 * of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * 设下标 l 和 r，把左开右闭 [l, r) 想象成一个窗口。
 *
 * 当窗口包含所有 T 中的字符时，则此时的窗口是一个可行解，l++
 * 当窗口没有包含所有 T 中的字符时，则 r++;
 */
public class MinimumWindowSubstring {


    public String minWindow(String s, String t) {

        return "";
    }
}
