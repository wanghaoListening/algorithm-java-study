package com.haothink.jzoffer;
import	java.util.Arrays;
import	java.util.Objects;


/**
 * @author wanghao
 * @date 2019年07月14日 20:32
 * description: 调整数组顺序使奇数位于偶数前面
 *
 * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变
 *
 * [1][2][3][4][5]
 * [1][3][5][2][4]
 *
 * 方法一：创建一个新数组，时间复杂度 O(N)，空间复杂度 O(N)。
 * 方法二：使用冒泡思想，每次都当前偶数上浮到当前最右边。时间复杂度 O(N2)，空间复杂度 O(1)，时间换空间。
 */
public class ChangePositionOfOddAndEven {


    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(changePosition2(nums)));
    }

    //创建一个新数组，时间复杂度 O(N)，空间复杂度 O(N)。
    private static int[] changePosition(int[] nums){
        if(Objects.isNull(nums) || 0 == nums.length){
            return null;
        }

        int numberOfOdd = 0;

        for(int num : nums){
            if(num % 2 ==1){
                numberOfOdd ++;
            }
        }

        int oddStartIndex = 0;
        int evenStartIndex = numberOfOdd;
        int[] newNumArray = new int[nums.length];
        for(int num : nums){

            if(num % 2 ==1){
                //奇数
                newNumArray[oddStartIndex++] = num;
            }else {
                //偶数
                newNumArray[evenStartIndex++] = num;
            }
        }
        return newNumArray;

    }


    private static int[] changePosition2(int[] nums){
        if(Objects.isNull(nums) || 0 == nums.length){
            return null;
        }


        int temp = 0;
        for(int i=0;i < nums.length-1; i++){

            for(int j=0;j<nums.length-1-i; j++){

                if (nums [j] % 2 == 0 && nums [j+1] % 2 == 1){
                    //偶数
                    //奇数,直接交换位置
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;

                }
            }
        }


        return nums;
    }


}
