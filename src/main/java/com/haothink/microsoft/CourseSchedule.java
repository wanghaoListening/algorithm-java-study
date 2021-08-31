package com.haothink.microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


/**
 * Created by wanghao on 2021/8/27
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you
 * must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 * 这道题的本质就是在有向图中检测环。 LeetCode 中关于图的题很少，有向图的仅此一道
 * 如何来表示一个有向图，可以用边来表示，边是由两个端点组成的，用两个点来表示边
 *
 * This problem can be converted to finding if a graph contains a cycle.
 * 这个题目就是标准的拓扑排序(topological sort)可以用dfs做，也可以用bfs做，这里用bfs来做
 * bfs的基本思路是维护每个节点的indegree, 就是有多少个节点指向这个节点， 然后从indegree=0的节点开始，就是不依赖于其他任何节点的开始。
 * 然后在遍历的过程中， 取出一个节点，就把他指向的节点的入度更新。
 * 循环这个过程直到不能再找到入度为0的节点。
 * 如果最后可以访问到所有的节点，那么就返回true，否则就返回false
 **/
public class CourseSchedule {


  public static void main(String[] args) {

    int numCourses = 2;
    int[][] prerequisites = {{1,0},{0,1}};

    CourseSchedule courseSchedule = new CourseSchedule();

    System.out.println(courseSchedule.canFinish(numCourses,prerequisites));
  }


  public boolean canFinish(int numCourses, int[][] prerequisites) {

    Map<Integer,Integer> inDegreeMap = new LinkedHashMap<>();

    Map<Integer, Set<Integer>> inDegreeEleMap = new LinkedHashMap<>();

    for(int i=0;i<prerequisites.length;i++){
      int[] course = prerequisites[i];

      if(inDegreeMap.containsKey(course[1])){
        inDegreeMap.put(course[1],inDegreeMap.get(course[1])+1);
      }else {
        inDegreeMap.put(course[1],1);
      }

      if(!inDegreeMap.containsKey(course[0])){
        inDegreeMap.put(course[0],0);
        Set<Integer> courseSet = new HashSet<>();
        courseSet.add(course[1]);
        inDegreeEleMap.put(course[0],courseSet);
      }else {
        Set<Integer> courseSet = inDegreeEleMap.containsKey(course[0])?inDegreeEleMap.get(course[0]):new HashSet<>();

        courseSet.add(course[1]);
        inDegreeEleMap.put(course[0],courseSet);
      }
    }

    removeZeroInDegreeNode(inDegreeMap,inDegreeEleMap);

    return inDegreeMap.isEmpty();
  }


  private void removeZeroInDegreeNode(Map<Integer,Integer> inDegreeMap,Map<Integer, Set<Integer>> inDegreeEleMap){

    List<Integer> zeroDegreeList = new ArrayList<>();
    inDegreeMap.forEach((course, inDegree) -> {
      if(inDegree == 0){
        zeroDegreeList.add(course);
      }
    });
    if(zeroDegreeList.isEmpty()){
      return;
    }

    for(Integer course : zeroDegreeList){
      inDegreeMap.remove(course);
      Set<Integer> inDegreeSet = inDegreeEleMap.get(course);
      if(Objects.isNull(inDegreeSet) || inDegreeSet.isEmpty()){
        continue;
      }
      for(Integer inCourse : inDegreeSet){
        inDegreeMap.put(inCourse,inDegreeMap.get(inCourse)-1);
      }
      inDegreeEleMap.remove(course);
    }

    removeZeroInDegreeNode(inDegreeMap,inDegreeEleMap);
  }
}
