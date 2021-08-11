package com.haothink.tencent;

/**
 * Created by wanghao on 2021/8/11
 *
 * 堆排序
 * 最大堆調整（Max_Heapify）：將堆的末端子節點作調整，使得子節點永遠小於父節點
 * 創建最大堆（Build_Max_Heap）：將堆所有數據重新排序
 * 堆排序（HeapSort）：移除位在第一個數據的根節點，並做最大堆調整的遞歸運算
 **/
public class HeapSort {

  // sign = 1 ==> min-heap, sign = -1 ==> max-heap
  private void siftDown(int[] nums, int k, int size, int sign) {
    int half = (size >>> 1);
    while (k < half) {
      int index = k;
      // left leaf node search
      int l = (k << 1) + 1;
      if (l < size && (sign * nums[l]) < (sign * nums[index])) {
        index = l;
      }
      // right leaf node search
      int r = l + 1;
      if (r < size && (sign * nums[r]) < (sign * nums[index])) {
        index = r;
      }
      // already heapify
      if (k == index) break;
      // keep the root node the smallest/largest
      int temp = nums[k];
      nums[k] = nums[index];
      nums[index] = temp;
      // adjust next index
      k = index;
    }
  }

  private void heapify(int[] nums, int size, int sign) {
    for (int i = size / 2; i >= 0; i--) {
      siftDown(nums, i, size, sign);
    }
  }

  private void minHeap(int[] nums, int size) {
    heapify(nums, size, 1);
  }

  private void maxHeap(int[] nums, int size) {
    heapify(nums, size, -1);
  }

  public void sort(int[] nums, boolean ascending) {
    if (ascending) {
      // build max heap
      maxHeap(nums, nums.length);
      // heap sort
      for (int i = nums.length - 1; i >= 0; i--) {
        int temp = nums[0];
        nums[0] = nums[i];
        nums[i] = temp;
        // reconstruct max heap
        maxHeap(nums, i);
      }
    } else {
      // build min heap
      minHeap(nums, nums.length);
      // heap sort
      for (int i = nums.length - 1; i >= 0; i--) {
        int temp = nums[0];
        nums[0] = nums[i];
        nums[i] = temp;
        // reconstruct min heap
        minHeap(nums, i);
      }
    }
  }
}
