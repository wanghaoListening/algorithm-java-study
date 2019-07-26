package com.haothink.bjtu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年07月26日 10:15
 * description: 魔法
 *
 * 题面描述
 * 魔法部急缺一批魔法师，于是他们急急忙忙新招聘了一批魔法师，应聘魔法师在他们上交的简历里写了各自的学历。学历仅包括初级魔法、中级魔法和高级魔法三门课程的成绩情况，用百分制表达。如果一位魔法师在某门课程上及格 (>=60 分 ) 的话，他就能得到相应的职称并担任对应的职业。当然，有高级职称的人可以担任低级职业。由于交上来的简历太多了，魔法部的负责人找到了你，想让你帮忙计算，能担任初级、中级、高级魔法师的人分别有多少人 ?
 *
 * 输入数据
 * 输入数据第一行为一个正整数 T ，表示测试数据的组数。 接下来是 T 组测试数据，每组测试数据的第一行为一个整数 n ，表示简历份数，随后的 n 行中，每行以低级、中级、高级的顺序表示三门课的成绩（ 1≤T≤100 ， 1≤n≤1000 ， 0≤ 成绩 ≤100 ）。
 *
 * 输出数据
 * 对于每一组输入数据，输出一行形如 ”Case #id: a b c” 的结果 , 表示第 id 组数据结果是 a,b,c ， id 从 1 开始， a,b,c 表示三种人的数量。
 *
 * 样例输入
 * 2
 * 3
 * 12 23 99
 * 66 66 77
 * 99 88 23
 * 2
 * 100 100 100
 * 100 100 100
 *
 * 样例输出
 * Case #1: 3 3 2
 * Case #2: 2 2 2
 */
public class MoFa {

    public static void main(String[] args) {



        Scanner scan = new Scanner(System.in);

        String numOfGroup = scan.nextLine();

        List<Group> groups = new ArrayList<>(Integer.parseInt(numOfGroup));
        for(int i=0;i<Integer.parseInt(numOfGroup);i++){

            Group group = new Group();
            String line = scan.nextLine();
            int resumes = Integer.parseInt(line);
            group.count = resumes;
            List<Resume> resumeList = new ArrayList<>();
            for(int j=0;j<resumes;j++){
                String resumeLine = scan.nextLine();
                String[] nums = resumeLine.split(" ");
                Resume resume = new Resume(Integer.parseInt(nums[0]),Integer.parseInt(nums[1]),Integer.parseInt(nums[2]));
                resumeList.add(resume);
            }
            group.setResumes(resumeList);
            groups.add(group);
        }

        for(int i=0;i<groups.size();i++){

            int numberOfJunior = 0;
            int numberOfMiddle = 0;
            int numberOfAdvance = 0;
            for(Resume resume : groups.get(i).getResumes()){

                if(resume.isJunior()){
                    numberOfJunior ++;
                }

                if(resume.isMiddle()){
                    numberOfMiddle ++;
                }

                if(resume.isAdvance()){
                    numberOfAdvance ++;
                }
            }
            System.out.println("Case #"+(i+1)+": "+numberOfJunior+" "+numberOfMiddle+" "+numberOfAdvance);

        }

    }


    private static class Group{

        private int count;
        List<Resume> resumes;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<Resume> getResumes() {
            return resumes;
        }

        public void setResumes(List<Resume> resumes) {
            this.resumes = resumes;
        }
    }



    /**
     * 简历
     */
    private static class Resume{


        //初级
        private int juniorScore;

        //中级
        private int middleScore;

        //高级
        private int advanceScore;

        private boolean isJunior;

        private boolean isMiddle;

        private boolean isAdvance;

        public Resume(int juniorScore, int middleScore, int advanceScore) {
            this.juniorScore = juniorScore;
            this.middleScore = middleScore;
            this.advanceScore = advanceScore;
        }

        public boolean isJunior() {


            return advanceScore >=60 || middleScore >=60 || juniorScore>=60;
        }

        public boolean isMiddle() {
            return advanceScore >=60 || middleScore >=60;
        }

        public boolean isAdvance() {
            return advanceScore >=60 ;
        }
    }

}
