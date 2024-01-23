package com.practice.easyalgo;

public class CalculateAmountPaidInTaxesSolution {

    public static void main(String[] args){
        CalculateAmountPaidInTaxesSolution capt = new CalculateAmountPaidInTaxesSolution();

        System.out.println(capt.calculateTax(new int[][]{{3,50},{7,10},{12,25}}, 10));
    }

    public double calculateTax(int[][] brackets, int income) {
        int idx = 0;
        double tax = 0;
        int prevUl = 0;
        if (income==0) return tax;
        while(income > brackets[idx][0]){
            tax = tax + (brackets[idx][0] - prevUl) * ((double)brackets[idx][1]/100);
            System.out.println(tax);
            prevUl = brackets[idx][0];
            idx ++;
        }
        tax = tax + (income - prevUl) * ((double)brackets[idx][1]/100);
        return tax;
    }

}
