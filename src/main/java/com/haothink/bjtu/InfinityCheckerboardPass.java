package com.haothink.bjtu;

import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年07月29日 09:54
 * description:Infinity的棋盘密码
 *
 *
 */
public class InfinityCheckerboardPass {


    private static final char[][] CHECKER_BOARD =
            new char[][]{
            {'A','B','C','D','E'},
            {'F','G','H','I','K'},
            {'L','M','N','O','P'},
            {'Q','R','S','T','U'},
            {'V','W','X','Y','Z'}};


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String numOfExample = scan.nextLine();
        String[] lines = new String [Integer.parseInt(numOfExample)];
        for(int i=0;i<Integer.parseInt(numOfExample);i++){
            String line = scan.nextLine();
            lines[i] = line.substring(line.indexOf(' ')+1);
        }

        for(int i=0;i<lines.length;i++){
            String[] chs = lines[i].split(" ");
            String passStr = getPass(chs);
            System.out.println("Case #"+(i+1)+": "+passStr);

        }

    }



    private static String getPass(String[] passNums){

        StringBuilder passStr = new StringBuilder();

        for(String str:passNums){
            passStr.append(CHECKER_BOARD[Character.getNumericValue(str.charAt(0))-1][Character.getNumericValue(str.charAt(1))-1]);
        }

        return passStr.toString();
    }


}
