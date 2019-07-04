package com.haothink;

/**
 * @author wanghao
 * @date 2019年06月26日 22:57
 * description:
 *
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 1.假设当有n个台阶时假设有f(n)种走法。
 * 2.青蛙最后一步要么跨1个台阶要么跨2个台阶。
 * 3.当最后一步跨1个台阶时即之前有n-1个台阶，根据1的假设即n-1个台阶有f(n-1)种走法。
 * 4. 当最后一步跨2个台阶时即之前有n-2个台阶，根据1的假设即n-2个台阶有f(n-2 )种走法。
 * 5.显然n个台阶的走法等于前两种情况的走法之和即f(n)=f(n-1)+f(n-2)。
 * 6.找出递推公式后要找公式出口，即当n为1、2时的情况，显然n=1时f(1)等于1，f(2)等于2
 *
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
