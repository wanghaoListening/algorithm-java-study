package com.haothink.merico;

public class CalFn {


    public static void main(String[] args) {

        CalFn cal = new CalFn();

        System.out.println(cal.F(100));
    }

    public long F(int n){

        if (n <=2){

            return 1;
        }
        long num[] = new long[n + 3];
        num[0] = 1;
        num[1] = 1;
        num[2] = 1;

        for (int i = 3; i <= n; i++) {
            num[i] = num[i - 1] + num[i - 3];
        }
        return num[n];
    }



}
