package com.haothink.futu;


import java.util.LinkedList;

public class FuTuTest {


    public static class StepPrice{
        int startStep ;
        int endStep ;
        Float price;

        public StepPrice(int startStep ,int endStep,Float price){
            this.startStep = startStep;
            this.endStep = endStep;
            this.price = price;
        }
    }

    public static LinkedList<StepPrice> feeSteps = new LinkedList<>();

    static {

        feeSteps.addLast(new StepPrice(1,5,Float.valueOf("30.00")));
        feeSteps.addLast(new StepPrice(6,20,Float.valueOf("15.00")));
        feeSteps.addLast(new StepPrice(21,50,Float.valueOf("10.00")));
        feeSteps.addLast(new StepPrice(51,100,Float.valueOf("9.00")));
        feeSteps.addLast(new StepPrice(101,500,Float.valueOf("8.00")));
        feeSteps.addLast(new StepPrice(501,1000,Float.valueOf("7.00")));
        feeSteps.addLast(new StepPrice(1001,2000,Float.valueOf("6.00")));
        feeSteps.addLast(new StepPrice(2001,3000,Float.valueOf("5.00")));
    }

    public float payFeeMonthly(int transactionCount){

        float sum = 0;
        while (transactionCount > 0){
            StepPrice stepPrice = feeSteps.removeFirst();
            if (stepPrice.endStep >= transactionCount){
                sum += transactionCount * stepPrice.price;
                transactionCount = 0;
                break;
            }else {
                transactionCount = transactionCount - stepPrice.endStep;
                sum += (stepPrice.endStep-stepPrice.startStep) * stepPrice.price;
            }
        }
        return sum;

    }
}
