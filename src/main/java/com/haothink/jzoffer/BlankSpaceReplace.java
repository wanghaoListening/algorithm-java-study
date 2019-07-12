package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年06月12日 23:05
 * description:
 *
 * 将一个字符串中的空格替换成 "%20"。
 *
 * Input:
 * "A B"
 *
 * Output:
 * "A%20B"
 *
 * 在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），
 * 因此当遍历到一个空格时，需要在尾部填充两个任意字符。
 *
 * 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，当 P1 遍历
 * 到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。
 *
 * 从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。
 */
public class BlankSpaceReplace {


    public static void main(String[] args) {
        //String str = "A BC  D";
        StringBuilder stringBuilder = new StringBuilder("A BC  D");
        System.out.println(replaceBlankSpace2(stringBuilder));
    }


    private static String replaceBlankSpace1(String str){

        char[] chs = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<=chs.length-1;i++){

            if(chs[i] == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(chs[i]);
            }
        }
        return stringBuilder.toString();
    }

    private static String replaceBlankSpace2(StringBuilder stringBuilder){

        int p1 = stringBuilder.length()-1;

        for(int i=0;i<=p1;i++){

            if(stringBuilder.charAt(i) == ' '){
                stringBuilder.append("  ");
            }
        }

        int p2 = stringBuilder.length()-1;

        while (p1 > 0 && p2 >p1){

            //先赋值再--
            char ch = stringBuilder.charAt(p1--);

            if(ch == ' '){
                stringBuilder.setCharAt(p2--,'0');
                stringBuilder.setCharAt(p2--,'2');
                stringBuilder.setCharAt(p2--,'%');
            }else{
                stringBuilder.setCharAt(p2--,ch);
            }
        }

        return stringBuilder.toString();
    }

}
