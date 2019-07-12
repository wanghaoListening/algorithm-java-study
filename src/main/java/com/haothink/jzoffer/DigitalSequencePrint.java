package com.haothink.jzoffer;

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

        printToMaxOfNDigitsByChar(4);
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


    /**
     * 我们发现数的每一位都是0到9，所以可以利用全排列的思想，凭借递归的优雅实现达到目的
     * @param n
     *       整数的位数
     */
    private static void printToMaxOfNDigitsByChar(int n){

        if(n <= 0) {
            return;
        }
        char[] nums = new char[n];
        recursiveProductNum(0, n, nums);
    }

    private static void recursiveProductNum(int index, int length, char[] nums) {
        if(index == length) {
            printNum(nums);
            return;
        }
        for(char i = '0'; i <= '9'; i++){
            nums[index] = i;
            recursiveProductNum(index + 1, length, nums);
        }
    }

    private static void printNum(char[] nums) {
        int index = 0;
        for(; index < nums.length; index++) {
            if(nums[index] != '0'){
                break;
            }
        }
        for(; index < nums.length; index++) {
            System.out.print(nums[index]);
        }
        System.out.println();
    }

}


