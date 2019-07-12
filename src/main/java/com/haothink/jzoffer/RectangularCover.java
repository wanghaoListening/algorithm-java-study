package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年06月24日 23:15
 * description: 矩形覆盖
 *
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 *
 * 要覆盖 2*n 的大矩形，可以先覆盖 2*1 的矩形，再覆盖 2*(n-1) 的矩形；或者先覆盖 2*2 的矩形，再覆盖 2*(n-2) 的矩形。
 * 而覆盖 2*(n-1) 和 2*(n-2) 的矩形可以看成子问题。该问题的递推公式如下：
 */
public class RectangularCover {


    public static void main(String[] args) {
        System.out.println(coverRectangular(10));
    }


    public static int coverRectangular(int n){

        if(n <=2){
            return n;
        }

        int fib1 = 1;
        int fib2 = 2;
        int fib = 0;

        for(int i=3;i<=n;i++){

            fib = fib1 +fib2;
            fib1 = fib2;
            fib2 = fib;

        }
        return fib;
    }

}
