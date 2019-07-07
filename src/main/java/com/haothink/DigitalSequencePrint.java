package com.haothink;

/**
 * @author wanghao
 * @date 2019年07月06日 19:31
 * description: 打印从 1 到最大的 n 位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 *
 * 我们在这里假设n足够大，Java中long最大可以达到2的64次方，即9223372036854775807，所以n不能超过18.
 * 倘若n超过18，那只能使用下面这种方式了。
 */
public class DigitalSequencePrint {


    public static void main(String[] args) {

        printToMaxOfNDigits(18);
    }

    private static void printToMaxOfNDigits(int n){

        if(n <= 18){

            printToMaxOfNDigitsByLong(n);
        }

    }


    private static void printToMaxOfNDigitsByLong(int n){

        long maxDigit = 9;
        for(int i=0;i<n-1;i++){
            maxDigit = maxDigit * 10 + 9;
        }

        for(long j=1;j<=maxDigit;j++){
            System.out.println(j);
        }
    }

    private static void printToMaxOfNDigitsByChar(int n){


    }
}


