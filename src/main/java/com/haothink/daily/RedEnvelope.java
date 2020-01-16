package com.haothink.daily;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wanghao on 2020-01-16
 * mail:wanghaotime@qq.com
 *
 * 群红包算法实现:
 *
 * 1.普通手气红包
 * 2.差距较大的心跳红包
 **/
public class RedEnvelope {

    public static void main(String[] args) {

        //将金额转换成分
        luckyRedPackage(100*10*10,20);
    }



    public static void luckyRedPackage(int amount,int nums){

        int min = 1;
        int max = (amount/nums) * 3; //最多3倍平均红包

        List<Integer> randomSeedList = random(nums,min,max);

        List<Integer> packageValueList = generatePieces(amount,nums,randomSeedList);

        System.out.println(packageValueList);
    }



    /**
     * 单位为 分
     * 在给定的区间范围内生成红包随机种子列表
     * [min max)
     * @param nums
     *        红包个数
     * @param min
     *        区间下界
     * @param max
     *        区间上界
     * @return
     *
     */
    private static List<Integer> random(int nums,int min,int max){

        Random randomSeeder = new Random(max);
        //种子区间大小
        int interval = max - min;
        List<Integer> seedList = new ArrayList<>();
        for(int i=0;i<nums;i++){

            seedList.add(min + randomSeeder.nextInt(interval));
        }
        return seedList;

    }





    /**
     * 单位为 分
     * @param amount
     *        红包总金额
     * @param nums
     *        红包个数
     * @param seedList
     *        随机种子列表
     * @return
     */
    private static List<Integer> generatePieces(int amount,int nums,List<Integer> seedList){

        List<Integer> redPackageList = new ArrayList<>(nums);

        //剩余金额
        int surplusAmount = amount - nums;

        //求和
        int seedSum = seedList.stream().reduce(0, Integer::sum);

        //随机后剩余金额
        int randomSurplusAmount = 0;

        for(Integer seed : seedList){

            //根据随机种子对剩余金额加权分配（+1 保证每个红包至少一分钱）
            int redPackageValue = 1 + (surplusAmount * seed) / seedSum;
            redPackageList.add(redPackageValue);
            randomSurplusAmount += redPackageValue;
        }

        surplusAmount = amount - randomSurplusAmount;

        Random randomSeeder = new Random();
        //剩余未被分配完的进行分配
        while (surplusAmount > 0){

            int index = randomSeeder.nextInt(nums);
            redPackageList.set(index,redPackageList.get(index)+1);
            surplusAmount --;
        }

        return redPackageList;
    }
}
