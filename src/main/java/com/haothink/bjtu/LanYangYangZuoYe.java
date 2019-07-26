package com.haothink.bjtu;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年07月26日 19:22
 * description: 懒羊羊的作业
 *
 * 题面描述
 * 看过国产动画片的同学都知道，懒羊羊是一只非常懒的羊，整天除了吃就是睡，根本没有时间做作业。明天就是周一了，村长慢羊羊留的作业：把 n 个整数从大到小排序，它还没开始写，真是一件让羊悲伤的事呀。
 * 但是，懒羊羊又是一只相当“机智”的羊，它发现村长年纪大了，这么多作业根本判不过来，只会检查作业的开头和结尾。所以懒羊羊想出了一个办法：把最大的数和第一个数交换，再把最小的数与最后一个数交换，
 * 其他的数位置不变。按这种方法得到的整数数列就可以瞒过村长啦。但是即使这样，懒羊羊也懒得去做，所以它来求助爱编程的你们啦。
 *
 * 输入数据
 * 第一行为 T ，表示有 T 组数据。
 *
 * 接下来 T 行，每行的第一个数为一个整数 n ，表示该行随后有 n 个整数，为要进行上述操作的 n 个数（保证这 n 个数中最大的数只有一个，最小的数也只有一个， T<=50;2<=n<=10000 ）。
 *
 * 输出数据
 * 对每组测试数据输出单独的一行结果，形如 ” Case #x: ans ” ，表示第 x 组的结果为 ans 。
 *
 * 样例输入
 * 2
 * 5 2 3 1 5 4
 * 6 9 11 2 0 7 2
 *
 * 样例输出
 * Case #1: 5 3 4 2 1
 * Case #2: 11 9 2 2 7 0
 */
public class LanYangYangZuoYe {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String numOfExample = scan.nextLine();
        String[] lines = new String [Integer.parseInt(numOfExample)];
        for(int i=0;i<Integer.parseInt(numOfExample);i++){
            String line = scan.nextLine();
            lines[i] = line.substring(2);
        }

        for(int i=0;i<lines.length;i++){
            String[] chs = lines[i].split(" ");
            int[] nums = new int[chs.length];
            for(int j=0;j<chs.length;j++){
                nums[j] = Integer.parseInt(chs[j]);
            }
            int[] sortNums = lanSort(nums);
            System.out.print("Case #"+(i+1));
            for(int j=0;j < sortNums.length;j++){
                System.out.print(" "+sortNums[j]);
            }
            System.out.println();
        }
    }

    private static int[] lanSort(int[] nums){

        if(Objects.isNull(nums) || nums.length == 0){
            return new int[5];
        }

        int bigTemp = nums[0];
        int bigIndex = 0;

        int smallTemp = nums[0];
        int smallIndex = 0;
        //向后
        for(int i=1;i<nums.length;i++){

            if(bigTemp > nums[i]){
                bigTemp = nums[i];
                bigIndex = i;
            }

            if(smallTemp < nums[i]){
                smallTemp = nums[i];
                smallIndex = i;
            }
        }
        if(bigIndex > 0 ){
            bigTemp = nums[nums.length-1];
            nums[nums.length-1] = nums[bigIndex];
            nums[bigIndex] = bigTemp;
        }

        if(smallIndex < nums.length-1){
            smallTemp = nums[0];
            nums[0] = nums[smallIndex];
            nums[smallIndex] = smallTemp;
        }

        return nums;
    }
}
