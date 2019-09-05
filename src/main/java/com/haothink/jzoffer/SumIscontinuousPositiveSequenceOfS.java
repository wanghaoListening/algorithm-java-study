package com.haothink.jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanghao
 * @date 2019年09月05日 14:55
 * description: 和为 S 的连续正数序列
 *
 *
 * 题目描述：
 * 输出所有和为S的连续正数序列。
 * 例如和为 100 的连续序列有：
 * [9, 10, 11, 12, 13, 14, 15, 16]
 * [18, 19, 20, 21, 22]。
 *
 * 解题思路：
 *
 * 可以设置两个指针pre,after指向初始列表1，2，pre,after分别向后移动，移动的规则如下：
 * 当num[pre]与num[after]区间的元素相加和等于s则找到元素列表
 * 当num[pre]与num[tail]区间的元素相加和大于s则tail不断向后移动，
 * 当num[pre]与num[tail]区间的元素相加和小于s则head不断向后移动
 *
 * 这里需要注意:设置pre变量，赋值为(1+s)/2，因为何为s的序列至少包括两个数，所以pre要小于s的一半；
 */
public class SumIscontinuousPositiveSequenceOfS {

    public static void main(String[] args) {

        System.out.println(findContinuousSequence(100));
    }


    private static List<List<Integer>> findContinuousSequence(int s){

        List<List<Integer>> lists = new ArrayList<>();
        int head = 1,tail = 2,mid = (1+s)/2;

        while (head < mid){

            int sum = (head+tail)*(tail+1-head)/2;
            if(sum == s){
                List<Integer> subList = new ArrayList<>();
                int cur = head;
                while (cur <= tail){
                    subList.add(cur);
                    cur++;
                }
                lists.add(subList);
                head++;
            }else if(sum < s){
                tail++;
            }else{
                head++;
            }

        }
        return lists;
    }

}
