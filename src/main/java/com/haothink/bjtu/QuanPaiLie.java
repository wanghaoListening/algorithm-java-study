package com.haothink.bjtu;

import java.util.*;

/**
 * @author wanghao
 * @date 2019年09月22日 21:07
 * description: 整数n的全排列
 *
 *
 *
 * 题目描述
 * 此题与剑指offer的字符串的全排列思想类似，所以可以参见StringSorted
 * 输入两个自然数m,n 1<=n<=20，1<=m<=n!
 * 输出n个数的第m种全排列。
 * 如 ：
 * 输入 3 1
 * 输出 1 2 3
 *
 * 输入数据
 * 在一行中输入 𝑛 𝑚
 * 输出数据
 * 一个数列,既 𝑛 个数的第 𝑚 种排列
 * 每两个数之间空 1 格
 * 样例输入
 * 3 2
 * 样例输出
 * 1 3 2
 */
public class QuanPaiLie {
    private static int global_m=0;
    private static int counter = 1;
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        String[] strs = input.nextLine().split(" ");
        int n=Integer.parseInt(strs[0]);
        int m=Integer.parseInt(strs[1]);
        getPermutation(n,m);

    }

    //非递归，全排列
    private static void getPermutation(int n,int m){

        List<Integer> sums = new ArrayList<>(n);
        List<Integer> nums = new ArrayList<>(n);
        int sum = 1;
        sums.add(1);
        for(int i=1;i<=n;i++){
            sum*=i;
            sums.add(sum);
            nums.add(i);
        }

        m--;
        List<Integer> results = new ArrayList<>();

        for(int i=1;i<=n;i++){
            int index = m/sums.get(n-i);
            results.add(nums.get(index));
            nums.remove(nums.get(index));
            m = m % sums.get(n-i);
        }
        for(int ele:results){
            System.out.print(ele+" ");
        }
    }



    private static void permutation(int[] num){
        if(Objects.isNull(num) || num.length == 0){
            return;
        }
        printNumArrange(num,0);
    }



    private static void printNumArrange(int[] num,int offset){
        if(offset == num.length-1){
            return;
        }
        if(offset == 0 && global_m == 1){
            System.out.println(Arrays.toString(num)
                    .replace("[","")
                    .replace(",","")
                    .replace("]",""));
        }
        int count = 1;
        for(int i=offset;i<num.length;i++){

            int temp = num[i];
            num[i] = num[offset];
            num[offset] = temp;
            //之所以count>1才输出，是因为,递归进入下一层时进行重复打印上一层的数字序列
            if(count >1) {
                counter ++;
                if(counter == global_m) {
                    System.out.println(Arrays.toString(num)
                            .replace("[","")
                            .replace(",","")
                            .replace("]",""));
                    break;
                }
            }
            printNumArrange(num,offset+1);
            count ++;
            //将位置重制
            temp = num[i];
            num[i] = num[offset];
            num[offset] = temp;
        }
    }


}
