package com.haothink.bjtu;


import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年07月26日 15:46
 * description: 求和
 *
 * 题面描述
 * 某一天， calfcamel 问二哥，有道数学题怎么做呀？二哥看了一下说我不会呀，于是二哥找到了你，请你帮他解决这个问题，这样二哥就可以鄙视 calfcamel 数学菜了。
 *
 * 给你一个长度为 n 的整数序列 a ，对该序列有 q 个查询，每次询问涉及序列中从 left 到 right 之间的数，包括 left 和 right ，请给出公式
 *
 * sum formula
 *
 * 的结果。即输出 [left, right] 这段区间中，第一个数乘以 1 ，第二个数乘以 2 ，第三个数乘以 3 ，……的和。
 *
 * 输入数据
 * 输入数据的第一行为一个正整数 T ，表示有 T 组数据。对于每组数据：
 *
 * 第一行是一个整数 n(n <= 100000) ；
 *
 * 第二行有 n 个整数构成的序列 a ，其中每个数均在 0 到 100000 之间；
 *
 * 第三行为一个整数 q(0<q <=100000) ，表示询问的数目；
 *
 * 接下来 q 行中，每行为两个整数 left 和 right ，表示查询的区间。
 *
 * 输出数据
 * 对于每一组数据，先单独输出一行 ”Case #x: ” ， x 为当前组的编号，从 1 开始。
 *
 * 随后的 q 行中，每行输出对应查询的答案。
 *
 * 样例输入
 * 2
 * 3
 * 1 2 3
 * 1
 * 1 3
 * 5
 * 1 2 3 4 5
 * 3
 * 1 5
 * 2 4
 * 3 5
 *
 * 样例输出
 * Case #1:
 * 14
 * Case #2:
 * 55
 * 20
 * 26
 *
 * 提示
 */
public class CalfcamelSum {


    private static final String SPACE = " ";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String numOfGroup = scan.nextLine();
        int groupCount = Integer.parseInt(numOfGroup);
        Group[] groups = new Group[groupCount];
        for(int i=0;i<groupCount;i++){

            Group group = new Group();
            int n = Integer.parseInt(scan.nextLine());
            String sequenceLine = scan.nextLine();
            int[] sequenceArray = new int[n];
            int ntCount = 0;

            for(String ch : sequenceLine.split(SPACE)){
                sequenceArray[ntCount] = Integer.parseInt(ch);
                ntCount++;
            }
            group.sequence = sequenceArray;
            String queryCountLine = scan.nextLine();
            int count = Integer.parseInt(queryCountLine);
            Range[] ranges = new Range[count];
            for(int j=0;j < count;j++){
                String rangeLine = scan.nextLine();
                String[] chs = rangeLine.split(SPACE);
                ranges[j] = new Range(Integer.parseInt(chs[0]),Integer.parseInt(chs[1]),sequenceArray);
            }
            group.ranges = ranges;
            groups[i] = group;

        }

        for(int i=0;i<groups.length;i++){

            Group group = groups[i];
            System.out.println("Case #"+(i+1));
            for(Range range:group.ranges){
                System.out.println(range.sum);
            }
        }

    }

    private static int getSum(int start,int end,int[] sequence) {
        int nt = 1;
        int sum =0;
        for(int i=start-1;i<end;i++){
            sum+=sequence[i]*nt;
            nt++;
        }
        return sum;
    }

    private static class Group{

        int[] sequence;
        Range[] ranges;

    }
    private static class Range {

        int start;

        int end;

        int sum;

        public Range(int start, int end, int[] sequence) {
            this.start = start;
            this.end = end;
            this.sum = getSum(start,end,sequence);
        }
    }
}
