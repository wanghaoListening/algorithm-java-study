package com.haothink;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年06月30日 15:19
 * description: 旋转数组
 *
 *
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *
 * 细想一下可以发现旋转之后的数组实际上可以划分为两个排序的子数组，而且前面排序的子数组的元素都大于或者等于后面子数组的元素，更重要的一点，最小的元素刚好是这两个子数组的分界线。
 * 在排序的数组中可以使用二分查找法实现O(logn)的查找。和二分查找法一样，使用两个指针分别指向数组的第一个元素和最后一个元素。
 * 接着可以找到数组中间的元素。如果中间元素大于等于前一个指针指向的元素，则中间元素位于前一个数组。此时数组中的最小元素应该位于该中间元素的后面，这时可以把第一个指针指向该中间元素缩小查找的范围，移动之后的第一个指针仍然位于前面的递增子数组。
 * 同样，同样如果中间指针小于等于第二个指针指向的元素。此时该数组的最小元素应该位于该中间元素的前面，可以把第二个指针指向该中间元素，移动之后的第一个指针仍然位于后面的递增子数组。
 * 不管移动第一个指针还是第二个指针，查找范围都会缩小到原来的一半。按照上述思路，第一个指针总是指向前面递增数组的元素，第二个指针总是指向后面递增数组的元素。最终第一个指针将指向前面子数组的最后应该元素，而第二个指针指向后面子数组的第一个元素。也就是它们最终会指向两个相邻的元素，而第二个指针指向的刚好是最小的元素。
 *
 */
public class RotateArray {


    public static void main(String[] args) {

        int[] array = {3, 4, 5, 1, 2};

        System.out.println(binarySearch(array));
    }

    private static int binarySearch(int[] nums){

        if(Objects.isNull(nums) || 0 == nums.length){
            return 0;
        }

        if(1 == nums.length){
            return nums[0];
        }


        int start = 0;
        int end = nums.length-1;
        int middle = (start + end)/2;

        while (start+1 < end){

            if(nums[middle] > nums[start]){
                //中间元素位于前一个数组中,最小值在中间元素的后面
                start = middle;
                middle = (start + end)/2;

            }else if(nums[middle] <= nums[end]){
                //中间元素位于后一个数组中,最小值在中间元素的前面
                end = middle;
                middle = (start + end)/2;
            }
        }
        return nums[end];
    }
}
