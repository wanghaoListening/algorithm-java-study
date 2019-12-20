package com.haothink.bjtu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wanghao on 2019-12-20
 * mail:wanghaotime@qq.com
 *
 * 定义一个无重复的数组candidates和一个目标数target,找出candidates当中所有可以使数字和为target的组合，candidates的数字可以无限制重复被选取
 *
 * candidates = {2,3,6,7}   target = 7
 *
 *
 * 2,2,3     7
 **/
public class SubSetWithDup {

    public static void main(String[] args) {

        int[] candidates = {2,3,6,7};

        int target = 7;

        System.out.println(combinationSum(candidates,target));

    }

    private static List<String> combinationSum(int[] candidates, int target){

        if(null == candidates || candidates.length <= 0){
            return new ArrayList<>();
        }

        //对原数组排序
        Arrays.sort(candidates);

        List<String> paths = new ArrayList<>();

        dfsSearch(candidates,0,target,"",paths);

        return paths;

    }

    private static void dfsSearch(int[] candidates, int i, int target, String path, List<String> paths){

        if(target == 0){
            paths.add(path);
        }else {

            for (int index = i; index < candidates.length; index++) {

                if (candidates[index] > target) {
                    return;
                }

                dfsSearch(candidates, index, target - candidates[index], path+" " + candidates[index], paths);
            }
        }
    }

}
