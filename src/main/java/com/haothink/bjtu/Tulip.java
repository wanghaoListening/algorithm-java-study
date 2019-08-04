package com.haothink.bjtu;

import java.util.*;

/**
 * @author wanghao
 * @date 2019年08月04日 11:47
 * description: 郁金香
 *
 * 题面描述
 *
 * 春天到了，校园里开满了郁金香。 Infinity 经过花坛的时候，常常会停下来数郁金香玩。
 *
 * Infinity 会分别统计不同颜色的花出现的次数，并把它们按照出现次数从多到少排序。
 *
 * 这次 Infinity 来到了一个很大的花坛前，和往常一样继续数郁金香。
 *
 * 不料，他数到一半时突然忘记数到哪了。 Infinity 不想从头开始数了，你能帮帮他吗？
 *
 * 输入数据
 *
 * 第一行有一个整数 t (1 ≤ t ≤ 100) ，表示有 t 组数据。
 *
 * 对于每组数据：
 *
 * 第一行有两个整数 n, m (1 ≤ n, m ≤ 100) ，表示花坛的长和宽；
 *
 * 接下来 n 行，每行有一个长度为 m 且由大写字母组成的的字符串，表示对应位置出现的花的种类。其中，相同的字母表示相同的花，不同的字母表示不同的花。
 *
 * 输出数据
 *
 * 对于每组数据：
 *
 * 第一行输出一个整数 k ，表示花坛中一共有 k 种不同的花。
 *
 * 接下来 k 行，每行输出一个整数 x 和一个字符 c ，表示出现了 x 个种类为 c 的花。
 *
 * 你需要按花出现的次数从大到小的顺序输出，如果多种花数量相同，请按花的种类从小到大输出。
 *
 * 样例输入
 *
 * 1
 * 3 3
 * ABC
 * BBC
 * CCC
 *
 * 样例输出
 *
 * 3
 * 5 C
 * 3 B
 * 1 A
 */
public class Tulip {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int groupCount = Integer.parseInt(scan.nextLine());
        Parterre[] parterres = new Parterre[groupCount];
        for(int i=0;i<groupCount;i++){
            Parterre parterre = new Parterre();
            String[] strs = scan.nextLine().split(" ");
            parterre.n = Integer.parseInt(strs[0]);
            parterre.m = Integer.parseInt(strs[1]);

            for(int j=0;j<parterre.n;j++){
                String flowerLine = scan.nextLine();
                char[] flspecs = flowerLine.toCharArray();
                for(Character ch: flspecs){
                    parterre.putClassNum(ch);
                }

            }
            parterres[i] = parterre;
        }

        for(Parterre parterre : parterres){

            Map<Integer,Character> map = parterre.getFlowerStatis();
            System.out.println(map.size());
            map.forEach((key,value)->{
                System.out.println(key+" "+value);
            });
        }

    }


    private static class Parterre{

        private static final Map<Character,Integer> flowerStatis = new HashMap<>();
        private static Map<Integer,Character> treeMap = new TreeMap<>(new MyCmp());

        public Integer n;
        public Integer m;



        public void putClassNum(Character classNum){

            Integer peoples = flowerStatis.get(classNum);

            if(Objects.nonNull(peoples)){
                flowerStatis.put(classNum,peoples+1);
                return;
            }
            flowerStatis.put(classNum,1);
        }


        public Map<Integer,Character> getFlowerStatis(){

            flowerStatis.forEach((key,value)->treeMap.put(value,key));
            return treeMap;
        }

        public static class MyCmp implements Comparator<Integer> {

            // 实现倒序
            @Override
            public int compare(Integer o1, Integer o2) {

                return o2-o1;
            }
        }


    }

}
