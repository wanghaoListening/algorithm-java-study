package com.haothink.bjtu;

import java.text.ParseException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wanghao on 2019-10-27
 * mail:wanghaotime@qq.com
 *
 * Problem A. 伊甸园日历游戏
 * 时间限制 1000 ms
 * 内存限制 128 MB
 * 题目描述
 * Adam和Eve玩一个游戏，他们先从1900.1.1到2001.11.4这个日期之间随意抽取一个日期出来。然后他们轮流对这个日期进行操作：
 *
 * 1 ： 把日期的天数加1，例如1900.1.1变到1900.1.2
 *
 * 2 ： 把月份加1，例如：1900.1.1变到1900.2.1
 *
 * 其中如果天数超过应有天数则日期变更到下个月的第1天。月份超过12则变到下一年的1月。而且进行操作二的时候，如果有这样的日期：1900.1.31，则变成了1900.2.31，这样的操作是非法的，我们不允许这样做。而且所有的操作均要考虑历法和闰年的规定。
 *
 * 谁先将日期变到2001.11.4谁就赢了。
 *
 * 每次游戏都是Adam先操作，问他有没有必胜策略？
 *
 * 输入数据
 * 一个测试点。多组数据。
 * 第一行为数据组数。
 * 接下来一行 X Y Z 表示 X 年 Y 月 Z 日
 * 输出数据
 * 输出“YES”or“NO”表示亚当是否有必胜策略。
 **/
public class EdenCalanderGame {

    private static final  LocalDate endDate = LocalDate.of(2001, 11, 4);

    public static void main(String[] args) throws ParseException {

        Scanner scan = new Scanner(System.in);
        String numOfExample = scan.nextLine();
        List<String> results = new ArrayList<>(Integer.parseInt(numOfExample));
        for(int i=0;i<Integer.parseInt(numOfExample);i++){
            String line = scan.nextLine();
            String[] strArray = line.split(" ");
            LocalDate date = LocalDate.of(Integer.parseInt(strArray[0]),Integer.parseInt(strArray[1]),Integer.parseInt(strArray[2]));
            String result = judgeResult(date);
            results.add(result);
        }

        results.forEach(result->System.out.println(result));
    }

    private static String judgeResult(LocalDate date){

        int count = 0;
        LocalDate localDate = date;
        while (endDate.isAfter(localDate)){

            count ++;
            if(count % 2 == 1) {
                localDate = addDate(localDate);
            }else{
                localDate = addMonth(localDate);
            }


        }

        return (count % 2 == 1) ? "YES":"NO";
    }


    private static LocalDate addDate(LocalDate date){

        return date.plus(1, ChronoUnit.DAYS);
    }

    private static LocalDate addMonth(LocalDate date){

        return date.plus(1,ChronoUnit.MONTHS);
    }


    private static boolean isLeapYear(int year){

        return (year%4==0&&year%100!=0||year%400==0);
    }

}
