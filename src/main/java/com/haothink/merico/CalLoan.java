package com.haothink.merico;

public class CalLoan {


    public static void main(String[] args) {

        CalLoan calLoa = new CalLoan();
        calLoa.calMonthsOfLoan();
    }


    public void calMonthsOfLoan(){

        double sumLoan = 1000000;// 100万贷款
        double rate = 0.03;
        int sumMonths = 0;
        double monthlyPay = 1500;
        double totalPay = 0;
        double extra = 0.05;
        int step = 0;
        while (sumLoan >= 0.0){
            sumMonths ++;
            step ++;
            if (step > 3){
                //超过三个月，本金5%
                monthlyPay += monthlyPay * extra;
                step = 0;
            }
            totalPay += monthlyPay;
            sumLoan -= monthlyPay;

            if (sumMonths % 12 == 0){
                //月底，计算利息
                sumLoan += sumLoan * rate;
            }
        }
        System.out.println("total months:"+sumMonths+"  total pay:"+totalPay);
    }
}
