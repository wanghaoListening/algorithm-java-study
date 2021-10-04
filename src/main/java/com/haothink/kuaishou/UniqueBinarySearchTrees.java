package com.haothink.kuaishou;

/**
 * Created by wanghao on 2021/10/4
 *
 * Given an integer n, return the number of structurally unique BST's (binary search trees)
 * which has exactly n nodes of unique values from 1 to n.
 *
 * n	BST的数目
 * 0	1
 * 1	1
 * 2	2
 * 3	5
 * 4	14
 * 5	42
 *
 * 利用根节点划分左右子树，通过它们的数目乘积得到以k为根节点的BST的数目，最后把所有这样的数目相加就能得到这样的结果，
 * 这个过程恰恰就是动态规划中子问题划分和求解的过程。
 *
 * 如果确定了根，那么就确定了左右子树有哪些节点，那么就可以简化成两个子树的BST的个数相乘，再枚举每个数作为根
 * 这个过程的结果就是卡特兰数的第n项
 *
 * 思路很简单，就是以某个点i作为根节点时，BST的数目为i左边所有点的BST的个数 * i右边所有点的BST的个数
 **/
public class UniqueBinarySearchTrees {


  public static void main(String[] args) {

  }

  public int numTrees(int n) {
    int[] nums = new int[n];
    //如果数组为空，毫无疑问，只有一种BST，即空树，
    nums[0] =1;
    //如果数组仅有一个元素{1}，只有一种BST，单个节点
    nums[1] =1;

    for(int i=2;i<=n;i++){
      int temp = 0;
      for(int j=0;j<i;j++){
        temp+=nums[j]*nums[i-j-1];
      }
      nums[i] = temp;
    }

    return nums[n];
  }

}
