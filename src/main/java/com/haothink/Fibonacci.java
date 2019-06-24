package com.haothink;

/**
 * @author wanghao
 * @date 2019年06月22日 22:58
 * description: 求斐波那契数列的第 n 项，n <= 39
 *
 * 递归是将一个问题划分成多个子问题求解，动态规划也是如此，但是动态规划会把子问题的解缓存起来，从而避免重复求解子问题。
 *
 */
public class Fibonacci {


    public static void main(String[] args) {

        System.out.println(getValueByN3(36));
    }

    //递归求解
    public static int getValueByN(int n){

        if(0 == n){
            return 0;
        }

        if(1 == n){
            return 1;
        }
        return getValueByN(n-1)+getValueByN(n-2);
    }


    //递归是将一个问题划分成多个子问题求解，动态规划也是如此，但是动态规划会把子问题的解缓存起来，从而避免重复求解子问题。
    public static int getValueByN2(int n){

        if(n <= 1){
            return n;
        }

        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;

        for(int i=2;i<=n;i++){

            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    //考虑到第 i 项只与第 i-1 和第 i-2 项有关，因此只需要存储前两项的值就能求解第 i 项，从而将空间复杂度由 O(N) 降低为 O(1)。
    public static int getValueByN3(int n){

        if(n <= 1){
            return n;
        }

        int fib = 0;
        int fib0 = 0;
        int fib1 = 1;

        for(int i=2;i<=n;i++){

            fib = fib0 + fib1;
            fib0 = fib1;
            fib1 = fib;
        }
        return fib;
    }




}
