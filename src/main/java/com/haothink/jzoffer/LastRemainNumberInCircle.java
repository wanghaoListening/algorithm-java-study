package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年09月15日 17:12
 * description: 圆圈中最后剩下的数
 *
 * 题目描述：
 *
 * 让小朋友们围成一个大圈。然后，随机指定一个数 m，让编号为 0 的小朋友开始报数。每次喊到 m-1 的那个小朋友要出列唱首歌，然后可以在礼品箱中任
 * 意的挑选礼物，并且不再回到圈中，从他的下一个小朋友开始，继续 0...m-1 报数 .... 这样下去 .... 直到剩下最后一个小朋友，可以不用表演。
 *
 * 解题思路：
 * 第一种方式可以使用环形链表模拟这个过程，相对来说容易理解，也可以使用数组来模拟这个过程，但无论是数组的方式还是链表的方式时间复杂度都太高。
 * 当n,m特别大时，没法在短时间内取得结果。
 * 第二种方式
 *
 * 𝑓(𝑖)  ={[𝑓(𝑖−1)+𝑚]%𝑖,0,i > 1
 *        1             i = 1
 *
 */
public class LastRemainNumberInCircle {


    public static void main(String[] args) {

        System.out.println(lastRemainingSolution(200,3));
    }


    private static int lastRemainingSolution(int n,int m){

        if(0 == n){
            return -1;
        }

        if(1 == n){
            return 0;
        }

        int result = 0;

        for(int i=1;i<=n-1;i++){

            result = (result + m)%i;
        }
        return result;
    }
}
