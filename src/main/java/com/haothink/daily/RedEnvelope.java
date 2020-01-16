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
 * 一.普通手气红包
 * 1.首先设定min和max区间，基于区间生成n个随机种子数
 * 2.预先为每一个红包预留一分钱，然后将amount - nums为随机分配的金额池
 * 3.基于步骤一当中的n个随机数种子对amount - nums进行加权分配,在分配值无法被整除的情况下，分配结果向下取整以保证金额不会被超发。
 *
 *
 *
 * 二.差距较大的心跳红包
 * 相比于普通手气红包，心跳红包的随机种子区间被分成2个部分，一个较低的区域和一个较高的区域，例如 [1-5) [15-20)
 * 首先按照比例确认进入那个随机种子区，然后再按照区间走普通手气的逻辑
 *
 **/
public class RedEnvelope {

    public static void main(String[] args) {

        //将金额转换成分
        luckyRedPackage(100*10*10,20);

        heartBeatRedPackage(100*10*10,20);
    }





    public static void luckyRedPackage(int amount,int nums){

        int min = 1;
        int max = (amount/nums) * 3; //最多3倍平均红包

        List<Integer> randomSeedList = random(nums,min,max);

        List<Integer> packageValueList = generatePieces(amount,nums,randomSeedList);

        System.out.println(packageValueList);
    }

    public static void heartBeatRedPackage(int amount,int nums){

        int lowerMin = 1;
        int lowerMax = (amount/nums) * 3; //最多3倍平均红包

        int upperMin = (amount/nums) * 3;

        int upperMax = (amount/nums) * 6;

        List<Integer> randomSeedList = heartBeatRandom(nums,lowerMin,lowerMax,upperMin,upperMax,80);

        List<Integer> packageValueList = generatePieces(amount,nums,randomSeedList);

        System.out.println(packageValueList);
    }



    /**
     *
     * @param nums
     *        红包个数
     * @param lowerMin
     *        红包金额低区间下界
     * @param lowerMax
     *        红包金额低区间上界
     * @param upperMin
     *        红包金额高区间下界
     * @param upperMax
     *        红包金额高区间上界
     * @param lowerPercent
     *        0-100 数值为0-100，数字越大进入红包金额高区间的就越小
     * @return
     */
    private static List<Integer> heartBeatRandom(int nums,int lowerMin,int lowerMax,int upperMin,int upperMax,int lowerPercent){

        List<Integer> seedList = new ArrayList<>();


        Random randomSeeder = new Random();

        int splitValue = 100;

        for(int i=0;i<nums;i++){

            if(randomSeeder.nextInt(splitValue) > lowerPercent){

                seedList.add(upperMin + randomSeeder.nextInt(upperMax - upperMin));
            }else{
                seedList.add(lowerMin + randomSeeder.nextInt(lowerMax - lowerMin));
            }
        }

        return seedList;

    }



    /**
     * 单位为 分
     * 在给定的区间范围内生成红包随机种子列表
     * [min max)
     * @param nums
     *        红包个数
     * @param min
     *        红包金额区间下界
     * @param max
     *        红包金额区间上界
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

            //根据随机种子对剩余金额加权分配（+1 保证每个红包至少一分钱）||
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
