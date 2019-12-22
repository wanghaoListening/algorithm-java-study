package com.haothink.bjtu;

/**
 * Created by wanghao on 2019-12-20
 * mail:wanghaotime@qq.com
 *
 * 给定n种物品和一背包。物品i的重量是wi>0，其价值为vi>0，背包的容量为c。问应如何选择装入背包中的物品，使得装入背包中物品的总价值最大？ （要求使用回溯法）
 *
 * 01背包属于找最优解问题，用回溯法需要构造解的子集树。对于每一个物品i，对于该物品只有选与不选2个决策，总共有n个物品，可以顺序依次考虑每个物品，这样就形成了一棵解空间树： 
 * 基本思想就是遍历这棵树，以枚举所有情况，最后进行判断，如果重量不超过背包容量，且价值最大的话，该方案就是最后的答案。
 *
 * 在搜索状态空间树时，只要左子节点是可一个可行结点，搜索就进入其左子树。对于右子树时，先计算上界函数，以判断是否将其减去（剪枝）。
 *
 * 上界函数bound():当前价值cw+剩余容量可容纳的最大价值<=当前最优价值bestp。　
 *
 *  为了更好地计算和运用上界函数剪枝，选择先将物品按照其单位重量价值从大到小排序，此后就按照顺序考虑各个物品。
 **/
public class KnapsackProblem {

    private static int n;//物品数量

    private static double c; //背包容量

    private static double[] v = new double[100]; //各个物品的价值　value

    private static double[] w = new double[100]; //各个物品的重量　weight

    private static double cw = 0.0; //当前背包重量　current weight

    private static double cp = 0.0;//当前背包中物品总价值　current value

    private static double bestp = 0.0;//当前最优价值best price

    private static double[] perp = new double[100];//单位物品价值(排序后) per price

    private static int[] order = new int[100];//物品编号

    private static int[] put = new int[100];//设置是否装入，为1的时候表示选择该组数据装入，为0的表示不选择该组数据


    public static void main(String[] args) {

        int i;
        System.out.println("请输入物品的数量和背包的容量：");
        n = 5;
        c = 30;

        System.out.println("请依次输入%d个物品的重量:"+n);
        for(i=1;i<=n;i++){
            System.out.println(w[i]);
            order[i]=i;
        }

        System.out.println("请依次输入%d个物品的价值:");
        for(i=1;i<=n;i++){
            System.out.println(v[i]);
        }

        knapsack();
        backtrack(1);

        System.out.println("最优价值为："+bestp);
        System.out.println("需要装入的物品编号是：");
        for(i=1;i<=n;i++) {
            if(put[i]==1)
                System.out.println(order[i]);
        }
    }

    //按单位价值排序
    private static void knapsack()
    {
        int i,j;
        int temporder = 0;
        double temp = 0.0;

        for(i=1;i<=n;i++)
            perp[i]=v[i]/w[i]; //计算单位价值（单位重量的物品价值）
        for(i=1;i<=n-1;i++)
        {
            for(j=i+1;j<=n;j++)
                if(perp[i]<perp[j])//冒泡排序perp[],order[],sortv[],sortw[]
                {
                    temp = perp[i];  //冒泡对perp[]排序
                    perp[i]=perp[i];
                    perp[j]=temp;

                    temporder=order[i];//冒泡对order[]排序
                    order[i]=order[j];
                    order[j]=temporder;

                    temp = v[i];//冒泡对v[]排序
                    v[i]=v[j];
                    v[j]=temp;

                    temp=w[i];//冒泡对w[]排序
                    w[i]=w[j];
                    w[j]=temp;
                }
        }
    }

    //回溯函数
    private static void backtrack(int i) {   //i用来指示到达的层数（第几步，从0开始），同时也指示当前选择玩了几个物品

        if(i>n) {//递归结束的判定条件
            bestp = cp;
            return;
        }
        //如若左子节点可行，则直接搜索左子树;
        //对于右子树，先计算上界函数，以判断是否将其减去
        if(cw+w[i]<=c)//将物品i放入背包,搜索左子树
        {
            cw+=w[i];//同步更新当前背包的重量
            cp+=v[i];//同步更新当前背包的总价值
            put[i]=1;
            backtrack(i+1);//深度搜索进入下一层
            cw-=w[i];//回溯复原
            cp-=v[i];//回溯复原
        }
        if(bound(i+1)>bestp)//如若符合条件则搜索右子树
            backtrack(i+1);
    }

    //计算上界函数，功能为剪枝
    private static double bound(int i) {   //判断当前背包的总价值cp＋剩余容量可容纳的最大价值<=当前最优价值
        double leftw= c-cw;//剩余背包容量
        double b = cp;//记录当前背包的总价值cp,最后求上界
        //以物品单位重量价值递减次序装入物品
        while(i<=n && w[i]<=leftw)
        {
            leftw-=w[i];
            b+=v[i];
            i++;
        }
        //装满背包
        if(i<=n)
            b+=v[i]/w[i]*leftw;
        return b;//返回计算出的上界

    }

}
