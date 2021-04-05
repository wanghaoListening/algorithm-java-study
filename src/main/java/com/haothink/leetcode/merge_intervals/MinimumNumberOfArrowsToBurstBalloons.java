package com.haothink.leetcode.merge_intervals;

import java.util.Arrays;

/**
 * Created by wanghao on 2021-04-05
 *
 * Given an array points where points[i] = [xstart, xend], return the minimum number of arrows
 * that must be shot to burst all balloons.
 * {{1,6},{2,8},{7,12},{10,16}}
 *
 * [[-2147483646,-2147483645],[2147483646,2147483647]]
 *
 * [[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]
 **/
public class MinimumNumberOfArrowsToBurstBalloons {


  public static void main(String[] args) {

    int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};

    MinimumNumberOfArrowsToBurstBalloons numberOfArrowsToBurstBalloons = new MinimumNumberOfArrowsToBurstBalloons();

    System.out.println(numberOfArrowsToBurstBalloons.findMinArrowShots(points));
  }


  public int findMinArrowShots(int[][] points) {

    if(points.length == 0){

      return 0;
    }

    Arrays.sort(points, (point1, point2) -> point1[1] >= point2[1]?1:-1);

    //Arrays.sort(points, (point1, point2) -> point1[0] >= point2[0]?1:-1);

    int count = 1;
    int startBorderNum = points[0][1];
    for(int i=1;i<points.length;i++){

      if(points[i][0] > startBorderNum){

        startBorderNum = points[i][1];
        count++;
      }
    }

    return count;
  }

}
