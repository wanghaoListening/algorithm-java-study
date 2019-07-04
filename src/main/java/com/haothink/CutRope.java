package com.haothink;

/**
 * @author wanghao
 * @date 2019年07月02日 21:25
 * description: 剪绳子
 *
 * 把一根大于1的绳子剪成0段或者多段，并且使得每段的长度乘积最大。
 *
 * n = 2
 * return 1 (2 = 1 + 1)
 *
 * n = 10
 * return 36 (10 = 3 + 3 + 4)
 *
 *
 *
 */
public class CutRope {


    public static void main(String[] args) {
        System.out.println(cutRope1(8));
        System.out.println(cutRope1(5));
        System.out.println(cutRope1(10));
    }
    /**
     *
     * @param n
     *    绳子长度
     * @return
     *    长度乘积最大值
     *
     *    贪心
     * 尽可能多剪长度为 3 的绳子，并且不允许有长度为 1 的绳子出现。如果出现了，就从已经切好长度为 3 的绳子
     * 中拿出一段与长度为 1 的绳子重新组合，把它们切成两段长度为 2 的绳子。
     *
     * 证明：当 n >= 5 时，3(n - 3) - n = 2n - 9 > 0，且 2(n - 2) - n = n - 4 > 0。因此在 n >= 5 的
     * 情况下，将绳子剪成一段为 2 或者 3，得到的乘积会更大。又因为 3(n - 3) - 2(n - 2) = n - 5 >= 0，所
     * 以剪成一段长度为 3 比长度为 2 得到的乘积更大。
     */
    private static int cutRope1(int n){

        if(1 == n) {
            return 1;
        }else if(2 == n){
            return 2;
        }else if(3 == n){
            return 2;
        }else if(4 == n){
            return 4;
        }

        int timeOfThree = n/3;
        int remainderNum = n%3;
        int multiNum = 1;
        if(1 == remainderNum){
            timeOfThree -=1;
            multiNum = 4;
        }else if(2 == remainderNum){
            multiNum = remainderNum;
        }

        for(int i=0;i<timeOfThree;i++){
            multiNum*=3;
        }

        return multiNum;
    }
}
