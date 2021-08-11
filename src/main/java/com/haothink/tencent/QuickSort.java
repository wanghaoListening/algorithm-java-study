package com.haothink.tencent;

/**
 * Created by wanghao on 2021/8/10
 *
 * 快速排序
 **/
public class QuickSort {

  public static void main(String[] args) {

  }

  public int[] sortArray(int[] nums) {

    quickSort(nums,0,nums.length-1);
    return nums;
  }

  private void quickSort(int arr[], int left, int right) {
    int index = partition(arr, left, right);
    if (left < index - 1)
      quickSort(arr, left, index - 1);
    if (index < right)
      quickSort(arr, index, right);
  }

  private int partition(int arr[], int left, int right) {
    int i = left, j = right;
    int tmp;
    int pivot = arr[(left + right) / 2];

    while (i <= j) {
      while (arr[i] < pivot)
        i++;
      while (arr[j] > pivot)
        j--;
      if (i <= j) {
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        i++;
        j--;
      }
    };
    return i;
  }



}
