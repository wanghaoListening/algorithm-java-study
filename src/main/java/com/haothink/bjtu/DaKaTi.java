package com.haothink.bjtu;

import java.util.Scanner;

/**
 * Created by wanghao on 2019-11-24
 * mail:wanghaotime@qq.com
 **/
public class DaKaTi {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String initLine = scan.nextLine();
        String[] nums = initLine.split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        String[][] matrix = new String[n][m];

        for(int i=0;i<n;i++){
            String newLine = scan.nextLine();
            matrix[i] = newLine.split(" ");
        }

        for(int i=0;i<m;i++){

            for(int j=n-1;j>=0;j--){
                System.out.print(matrix[j][i]+" ");
            }
            System.out.println();
        }
    }


}
