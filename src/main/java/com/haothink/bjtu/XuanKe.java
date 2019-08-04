package com.haothink.bjtu;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年07月29日 18:22
 * description: 选课
 *
 *题面描述
 *
 * 小刘所在的学校本学期共开设了 60 门课，并且每位同学会选修 5 门不同的课，小刘想知道是否存在一个 3 门课的集合，使得小刘所在班级有至少 p% （ p 为不超过 100 的非负整数） 的同学选修了这三门课。
 *
 * 输入数据
 *
 * 第一行有一个整数 t (1 ≤ t ≤ 20) ，表示有 t 组数据。
 *
 * 对于每组数据：
 *
 * 第一行有两个整数 n, p (2 ≤ n ≤ 100000,50 ≤ p ≤ 100) ， n 表示小明班级的人数；
 *
 * 接下来的 n 行，每行有 5 个整数 ai (0 ≤ ai ≤ 59) 表示该同学选修的课程号。
 *
 * 输出数据
 *
 * 对于每组数据，如果存在至少 p% 的同学选修相同的 3 门课程，输出一行“ yes ”，否则输出“ no ”。
 *
 * 样例输入
 *
 * 1
 * 5 80
 * 1 2 3 4 5
 * 1 2 3 4 5
 * 1 2 3 4 5
 * 1 2 3 4 5
 * 1 2 3 4 5
 *
 * 样例输出
 *
 * yes
 *
 */
public class XuanKe {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int groupCount = Integer.parseInt(scan.nextLine());
        Group[] groups = new Group[groupCount];
        for(int i=0;i<groupCount;i++){
            Group group = new Group();
            String[] strs = scan.nextLine().split(" ");
            group.peoples = Integer.parseInt(strs[0]);
            group.percent = Integer.parseInt(strs[1]);

            for(int j=0;j<group.peoples;j++){
                String classLine = scan.nextLine();
                String[] subjectNums = classLine.split(" ");
                group.putClassNum(subjectNums[0]);
                group.putClassNum(subjectNums[1]);
                group.putClassNum(subjectNums[2]);
                group.putClassNum(subjectNums[3]);
                group.putClassNum(subjectNums[4]);
            }
            groups[i] = group;
        }


        for(Group group : groups){
            System.out.println(group.statisticSubject());
        }


    }



    private static class Group{

        int peoples;
        int percent;
        Map<String,Integer> classMap = new HashMap<>();

        public void putClassNum(String classNum){

            Integer peoples = classMap.get(classNum);

            if(Objects.nonNull(peoples)){
                classMap.put(classNum,peoples+1);
                return;
            }
            classMap.put(classNum,1);
        }

        public String statisticSubject(){

            int count = 0;

            for(Integer num : classMap.values()){
                if((num*100)/peoples > percent){
                    count ++;
                }
            }

            if(count >= 3){
                return "yes";
            }
            return "no";
        }

    }



}
