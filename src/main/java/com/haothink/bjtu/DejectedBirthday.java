package com.haothink.bjtu;

import java.util.Scanner;

/**
 * Created by wanghao on 2019-12-01
 * mail:wanghaotime@qq.com
 *
 * 题目描述
 * 基德穿破层层障碍终于来到了" 忧郁的生日" 面前." 忧郁的生日" 如前题所述封存于密码锁中.这个密码锁不是一般的密码锁,这是不一
 * 般的密码锁！这个密码锁上显示着一串数字.旁边还有一串提示:The password is in the number.The number is on screen,you s-
 * hould delete N numbers as 1,2 or 3...9.The last number should be the smallest of all.The last number is then passwo-
 * rd（基德:靠,提示居然是E文,无视我400的智商吗?!).为了成功盗取并尽快赶去青子家，基德请你编一个程序解决这个密码锁。
 *
 * 输入数据
 * 输入共 2 行
 * 第一行为一个不超过250位的数字；
 * 第二行则为 N 。
 * 输出数据
 * 输出只有一行，即PASSWORD.
 * 样例输入
 * 178543
 * 4
 * 样例输出
 * 13
 **/
public class DejectedBirthday {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String numbers = scan.nextLine();
        Integer n = Integer.parseInt(scan.nextLine());
        char[] chs = numbers.toCharArray();


    }

}
