package com.haothink.bjtu;

import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年07月29日 11:25
 * description: 世纪难题
 *
 * 题面描述
 *
 * “晚饭吃什么？” Lazy_sheep 的女朋友问到。
 *
 * “咱这不才吃完午饭嘛！” Lazy_sheep 看着餐厅的菜谱，无奈的回答。
 *
 * 作为一个世纪难题，“晚饭吃什么”一直困扰着 Lazy_sheep 。
 *
 * 已知餐厅菜谱上的每一道菜前都写有一个正整数作为菜品编号，而他女朋友能记起前 n 顿饭吃的是哪些菜。如果今天晚饭和前 n 顿饭中某一顿吃的菜相同的话，她就会不开心。
 *
 * 现在 Lazy_sheep 随口说出了某个编号 w ，请你帮忙判断会不会到导致女朋友不开心。
 *
 * 输入数据
 *
 * 第一行有一个整数 t (1 ≤ t ≤ 100) ，表示有 t 组数据。
 *
 * 对于每组数据：
 *
 * 第一行有一个正整数 w (1 ≤ w ≤ 50) ，表示 Lazy_sheep 说出的菜品编号；
 *
 * 第二行有一个正整数 n (1 ≤ n ≤ 20) ；
 *
 * 第三行有 n 个不同的正整数 ai (1 ≤ i ≤ n,1 ≤ ai ≤ 50) ，表示前 n 顿饭吃的菜品编号。
 *
 * 输出数据
 *
 * 对于每组数据：
 *
 * 如果 w 是前 n 顿饭吃过的菜品编号，输出一行“ unhappy ”，否则输出“ happy ”。
 *
 * 样例输入
 *
 * 2
 * 1
 * 3
 * 1 2 3
 * 5
 * 5
 * 1 8 7 4 6
 *
 * 样例输出
 *
 * unhappy
 * happy
 */
public class CenturyDifficultie {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int groupCount = Integer.parseInt(scan.nextLine());
        Group[] groups = new Group[groupCount];
        for(int i=0;i<groupCount;i++){
            String veNumber = scan.nextLine();
            scan.nextLine();
            String[] ateNumber = scan.nextLine().split(" ");
            groups[i] = new Group(veNumber,ateNumber);
        }

        for(Group group : groups){
            String mood = girlFriendMood(group.veNumber,group.ateNumber);
            System.out.println(mood);
        }


    }


    private static class Group {
        public Group(String veNumber, String[] ateNumber) {
            this.veNumber = veNumber;
            this.ateNumber = ateNumber;
        }

        private String veNumber;
        private String[] ateNumber;
    }


    private static String girlFriendMood(String veNumber,String[] ateNumber){

        String result = "happy";
        for(String str: ateNumber){
            if(veNumber.equals(str)){
                result = "unhappy";
                break;
            }
        }
        return result;
    }
}
