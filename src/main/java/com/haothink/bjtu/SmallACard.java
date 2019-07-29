package com.haothink.bjtu;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wanghao
 * @date 2019年07月29日 13:55
 * description: 小A的卡片
 *
 * 题面描述
 *
 * 小 A 是一个卡片收藏的爱好者，他有一个非常大的正方形卡箱，卡箱中有 n × n 个格子，每个格子中都放着一张卡片，为了方便寻找卡片，小 A 给每个卡片标上一个整数值。卡箱中卡片的值满足从左向右非递减，从上到下非递减。
 *
 * 现给你一个卡片的值，你能快速的找到卡片的位置吗？
 *
 * 输入数据
 *
 * 第一行有一个整数 t (1 ≤ t ≤ 10) ，表示有 t 组数据。
 *
 * 对于每组数据：
 *
 * 第一行有一个整数 n (1 ≤ n ≤ 1000) ，表示正方形卡箱的边长；
 *
 * 接下来有 n 行，每行有 n 个整数 aij (1 ≤ aij ≤ 109) ，表示正方形卡箱中卡片的值。
 *
 * 接下来一行为有一个整数 q (1 ≤ q ≤ 104) ，表示有 q 个询问。对于每个询问：
 *
 * 第一行有一个整数 x (1 ≤ x ≤ 109) 。
 *
 * 保证 ∑ n2 ≤ 2 × 106, ∑ q ≤ 2 × 104 。
 *
 * 输出数据
 *
 * 对个每个询问，如果卡箱中有这张卡片，输出它的位置 x y ，反之输出 -1 。
 *
 * 如果有多个卡片值相同，请输出 x 最小的，如果还有多个相同的，请输出 y 最大的。
 *
 * 样例输入
 *
 * 2
 * 3
 * 1 3 5
 * 2 4 7
 * 6 8 9
 * 3
 * 1
 * 7
 * 10
 * 2
 * 1 1
 * 1 1
 * 1
 * 1
 *
 * 样例输出
 *
 * 1 1
 * 2 3
 * -1
 * 1 2
 */
public class SmallACard{



    private static final ExecutorService cachedThreadPool = Executors.newFixedThreadPool(30);

    private static final Map<Integer,Position> positions = Collections.synchronizedMap(new TreeMap<>());

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int groupCount = Integer.parseInt(scan.nextLine());
        int count =1;
        for(int i=0;i<groupCount;i++){

            int boxLength = Integer.parseInt(scan.nextLine());
            String[][] box = new String[boxLength][boxLength];
            for(int j=0;j<boxLength;j++){
                box[j] = scan.nextLine().split(" ");
            }
            int queryTimes = Integer.parseInt(scan.nextLine());

            for(int j=0;j<queryTimes;j++){
                String queryParam = scan.nextLine();
                cachedThreadPool.execute(new CalPosition(queryParam,box,count,positions));
                count++;
            }
        }
        cachedThreadPool.shutdown();
        while (true){
            if(cachedThreadPool.isTerminated()){
                for(Position position : positions.values()){
                    System.out.println(position.toString());
                }
                break;
            }
        }
    }

    private static class CalPosition implements Runnable {

        Map<Integer, Position> positions;
        String cardNum;
        String[][] cardBox;
        Integer count;


        public CalPosition(String cardNum, String[][] cardBox, Integer count, Map<Integer, Position> positions) {
            this.cardNum = cardNum;
            this.cardBox = cardBox;
            this.count = count;
            this.positions = positions;
        }

        @Override
        public void run() {
            boolean isExist = false;
            for (int i = 0; i <= cardBox.length - 1; i++) {
                for (int j = cardBox[0].length - 1; j >= 0; j--) {

                    if (cardNum.equals(cardBox[i][j])) {
                        isExist = true;
                        this.positions.put(count, new Position(i + 1, j + 1));
                        break;
                    }
                }
                if(isExist){
                    break;
                }
            }

            if (!isExist) {
                this.positions.put(count, new Position(-1, -1));
            }

        }

    }

    public static class Position {

        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return (-1 != x) ? (x+" "+y) : "-1";
        }
    }
}
