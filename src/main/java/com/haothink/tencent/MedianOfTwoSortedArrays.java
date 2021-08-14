package com.haothink.tencent;

/**
 * Created by wanghao on 2021/8/14
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 *
 * [100001]
 * [100000]
 **/
public class MedianOfTwoSortedArrays {


  public static void main(String[] args) {

    int[] nums1 = {100001};
    int[] nums2 = {100000};

    MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();

    System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(nums1,nums2));
  }



  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    if(nums1.length == 0){
      int medianIndex = ((nums2.length)%2 == 0?(nums2.length)/2:(nums2.length)/2);
      return (nums2.length)%2 == 0?((double)nums2[medianIndex-1]+(double)nums2[medianIndex])/2 : nums2[medianIndex];
    }

    if(nums2.length == 0){
      int medianIndex = ((nums1.length)%2 == 0?(nums1.length)/2:(nums1.length)/2);
      return (nums1.length)%2 == 0?((double)nums1[medianIndex-1]+(double)nums1[medianIndex])/2 : nums1[medianIndex];
    }
    int m = 0;
    int n = 0;
    int count = 0;
    int sum = nums1.length + nums2.length;
    int medianIndex = ((sum)%2 == 0?(sum)/2:(sum)/2);
    int[] sumArray = new int[medianIndex+1];
    while (count <= medianIndex){

      if(m >= nums1.length){
        sumArray[count] = nums2[n];
        n ++;
        count ++;
        continue;
      }
      if(n >= nums2.length){
        sumArray[count] = nums1[m];
        m ++;
        count ++;
        continue;
      }
      if(nums1[m] <= nums2[n]){
        sumArray[count] = nums1[m];
        m ++;
      }else{
        sumArray[count] = nums2[n];
        n ++;
      }
      count ++;
    }
    return (sum)%2 == 0?((double)sumArray[medianIndex-1]+(double)sumArray[medianIndex])/2 : sumArray[medianIndex];
  }

}
