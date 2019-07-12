package com.haothink.jzoffer;

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
        System.out.println(cutRope1(10));
        System.out.println(cutRope2(10));
    }
    /**
     *
     * @param length
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
    private static int cutRope1(int length){

        if(1 == length) {
            return 0;
        }else if(2 == length){
            return 1;
        }else if(3 == length){
            return 2;
        }else if(4 == length){
            return 4;
        }

        int timeOfThree = length/3;
        int remainderNum = length%3;
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

    /**
     * 动态规划
     * @param length
     *       绳子长度
     * @return
     *
     *
     * 首先定义函数f(n)为把长度为n的绳子剪成若干段后各段长度乘积的最大值。在剪第一刀时，我们有n-1种选择，
     * 也就是说第一段绳子的可能长度分别为1,2,3.....，n-1。因此f(n)=max(f(i)*f(n-i))，其中0<i<n。
     * 这是一个自上而下的递归公式。由于递归会有大量的不必要的重复计算。一个更好的办法是按照从下而上的顺序
     * 计算，也就是说我们先得到f(2),f(3)，再得到f(4),f(5)，直到得到f(n)。
     *
     */
    private static int cutRope2(int length){

        if(1 == length) {
            return 0;
        }else if(2 == length){
            return 1;
        }else if(3 == length){
            return 2;
        }else if(4 == length){
            return 4;
        }

        //0位置不存储数据，绳子没有0长度的情况
        int[] nums = new int[length+1];
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 3;
        nums[4] = 4;

        for(int i=5;i<nums.length;i++){
            int max = 0;
            for(int j=1;j<=i/2;j++){

                int temp = nums[j] * nums[i-j];

                if(temp > max){
                    max = temp;
                }
            }
            nums[i] = max;
        }

        return nums[length];
    }


}
