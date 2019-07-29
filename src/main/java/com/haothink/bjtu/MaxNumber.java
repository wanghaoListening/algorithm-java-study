package com.haothink.bjtu;

import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年07月29日 10:23
 * description: 最大的数
 *
 * 题面描述
 * 给你三个数 a, b, c ，求 a* b, b * c, c * a 三个数中的最大值
 *
 * 输入数据
 * 第一行有一个整数 T ，代表接下来有 T 组数据，每一组数据占单独的一行，包括三个整数 a, b 和 c 。
 *
 * 输出数据
 * 对于每组输入数据，在单独的行中输出 一行形如 "Case #id: a b c" 的结果 ，保证最大值不超过 32 位整数范围。
 *
 * 样例输入
 * 3
 * 1 1 1
 * 1 2 2
 * 3 1 2
 *
 * 样例输出
 * Case #1: 1
 * Case #2: 4
 * Case #3: 6
 */
public class MaxNumber {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String numOfExample = scan.nextLine();
        String[] lines = new String [Integer.parseInt(numOfExample)];
        for(int i=0;i<Integer.parseInt(numOfExample);i++){
            lines[i] = scan.nextLine();
        }

        for(int i=0;i<lines.length;i++){
            String[] chs = lines[i].split(" ");
            int[] nums = new int[chs.length];
            for(int j=0;j<chs.length;j++){
                nums[j] = Integer.parseInt(chs[j]);
            }
            int maxNum = getMaxNumber(nums);
            System.out.println("Case #"+(i+1)+": "+maxNum);

        }
    }


    private static int getMaxNumber(int[] nums){

        int a=nums[0],b=nums[1],c=nums[2];

        return c*a>(a*b>b*c?a*b:b*c)?c*a:(a*b>b*c?a*b:b*c);
    }
}
