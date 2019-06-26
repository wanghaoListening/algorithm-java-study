package com.haothink;

/**
 * @author wanghao
 * @date 2019年06月26日 22:57
 * description:
 *
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class StepJump {


    public static void main(String[] args) {
        System.out.println(jumpStep(5));
    }

    private static int jumpStep(int n){

        if(n<=2){
            return n;
        }
        int step1 = 1;
        int step2 = 2;
        int result = 0;
        for(int i=3;i<=n;i++){

            result = step1 + step2;
            step1 = step2;
            step2 = result;
        }

        return result;
    }
}
