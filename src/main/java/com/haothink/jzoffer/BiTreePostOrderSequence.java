package com.haothink.jzoffer;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年07月28日 12:48
 * description: 二叉搜索树的后序遍历序列
 *
 * 题目描述：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
 * 例如，下图是后序遍历序列 1,3,2 所对应的二叉搜索树。
 *
 * 解题思路：
 * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，那么T满足：
 * T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。
 *
 *
 */
public class BiTreePostOrderSequence {


    public static void main(String[] args) {

        int[] sequence = {11,7,6,9,11,10,8};
        System.out.println(verifySquenceOfBST(sequence));
    }


    private static boolean verifySquenceOfBST(int[] sequence){

        if(Objects.isNull(sequence) || sequence.length == 0){
            return false;
        }

        return isBST(sequence,0,sequence.length-1);
    }

    private static boolean isBST(int[] sequence,int start,int end){

        if(start >= end){
            return true;
        }
        //取根节点
        int root = sequence[end];

        int middleIndex = 0;
        //寻找左右子树的分界
        while (middleIndex <= end && sequence[middleIndex] <= root){
            middleIndex++;
        }

        //判断序列右边的节点是不是都大于root

        for(int i=middleIndex;i<end;i++){

            if(sequence[i] < root){
                return false;
            }
        }
        //需要注意由于已经去掉root节点所以应该是end-1
        return isBST(sequence,start,middleIndex-1)&& isBST(sequence,middleIndex,end-1);

    }
    
}
