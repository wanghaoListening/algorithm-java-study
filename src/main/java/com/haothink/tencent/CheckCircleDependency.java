package com.haothink.tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 * Created by wanghao on 2021/8/16
 *
 * 现有n个编译项，编号为0 ~ n-1。给定一个二维数组，表示编译项之间有依赖关系。如[0, 1]表示1依赖于0。
 * 若存在循环依赖则返回空；不存在依赖则返回可行的编译顺序。
 *
 * 若给定一个依赖关系是[[0,2],[1,2],[2,3],[2,4]]
 *
 * 可以看出，它们之间不存在循环依赖。
 * 可行的编译序列是[0,1,2,3,4]，也可以是[1,0,2,4,3]等。
 * 拓扑排序可以求这样的一个序列。可以看出，这个序列结果可能不唯一。
 *
 * 拓扑排序算法过程：
 *
 * 选择图中一个入度为0的点，记录下来
 * 在图中删除该点和所有以它为起点的边
 * 重复1和2，直到图为空或没有入度为0的点。
 * 借助BFS来实现拓扑排序，队列中存储入度为0的点。
 *
 * 检测循环依赖
 * 可行的编译序列是[0,1,2,3,4]，也可以是[1,0,2,4,3]等。
 **/
public class CheckCircleDependency {

  public static void main(String[] args) {

    int[][] paths = {{0,2},{1,2},{2,3},{2,4}};

    CheckCircleDependency checkCircleDependency = new CheckCircleDependency();

    System.out.println(checkCircleDependency.haveCircularDependency(paths));
  }

  public List<Integer> haveCircularDependency(int[][] prerequisites){

    List<Integer> results = new ArrayList<>();
    LinkedHashMap<Integer,Integer> degrees = new LinkedHashMap<>();
    LinkedHashMap<Integer,List<Integer>> paths = new LinkedHashMap<>();
    for(int i=0;i<prerequisites.length;i++){
      int in = prerequisites[i][0];
      int out = prerequisites[i][1];

      if(paths.containsKey(in)){
        List<Integer> values = paths.get(in);
        values.add(out);
        paths.put(in,values);
      }else {
        List<Integer> values = new ArrayList<>();
        values.add(out);
        paths.put(in,values);
      }
      if(!degrees.containsKey(in)) {
        degrees.put(in, 0);
      }
      if(degrees.containsKey(out)){
        degrees.put(out,degrees.get(out)+1);
      }else {
        degrees.put(out,1);
      }
    }

    while (!degrees.isEmpty()){
      Iterator<Entry<Integer, Integer>> it = degrees.entrySet().iterator();
      while(it.hasNext()){
        Map.Entry<Integer, Integer> entry = it.next();
        if(entry.getValue() == 0) {
          List<Integer> vals = paths.get(entry.getKey());
          if(Objects.nonNull(vals)) {
            for (Integer val : vals) {
              degrees.put(val, degrees.get(val) - 1);
            }
          }
          results.add(entry.getKey());
          it.remove();//使用迭代器的remove()方法删除元素
        }
      }
    }

    return results;
  }

}
