package com.haothink.bjtu;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年09月22日 21:07
 * description: 整数n的全排列
 *
 *
 *
 * 题目描述
 * 此题与剑指offer的字符串的全排列思想类似，所以可以参见StringSorted
 * 输入两个自然数m,n 1<=n<=20，1<=m<=n!
 * 输出n个数的第m种全排列。
 * 如 ：
 * 输入 3 1
 * 输出 1 2 3
 *
 * 输入数据
 * 在一行中输入 𝑛 𝑚
 * 输出数据
 * 一个数列,既 𝑛 个数的第 𝑚 种排列
 * 每两个数之间空 1 格
 * 样例输入
 * 3 2
 * 样例输出
 * 1 3 2
 */
public class QuanPaiLie {
    private static int m=0;
    private static int counter = 1;
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        String[] strs = input.nextLine().split(" ");
        int n=Integer.parseInt(strs[0]);
        m=Integer.parseInt(strs[1]);
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i] = i+1;
        }
        permutation(num);

    }

    private static void permutation(int[] num){
        if(Objects.isNull(num) || num.length == 0){
            return;
        }
        printNumArrange(num,0);
    }

    private static void printNumArrange(int[] num,int offset){
        if(offset == num.length-1){
            return;
        }
        if(offset == 0 && m == 1){
            System.out.println(Arrays.toString(num)
                    .replace("[","")
                    .replace(",","")
                    .replace("]",""));
        }
        int count = 1;
        for(int i=offset;i<num.length;i++){

            int temp = num[i];
            num[i] = num[offset];
            num[offset] = temp;
            //之所以count>1才输出，是因为,递归进入下一层时进行重复打印上一层的数字序列
            if(count >1) {
                counter ++;
                if(counter == m) {
                    System.out.println(Arrays.toString(num)
                            .replace("[","")
                            .replace(",","")
                            .replace("]",""));
                    break;
                }
            }
            printNumArrange(num,offset+1);
            count ++;
            //将位置重制
            temp = num[i];
            num[i] = num[offset];
            num[offset] = temp;
        }
    }

}
