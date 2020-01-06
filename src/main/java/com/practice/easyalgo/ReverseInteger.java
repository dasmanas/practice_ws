package com.practice.easyalgo;

public class ReverseInteger {

    public int reverse(int x){

        int reversedNum = 0;

        while (x!=0){
            int remainder = x % 10;
            x = x / 10;
            reversedNum = reversedNum * 10 + remainder;
        }
        return reversedNum;
    }

    public static void main(String args[]){
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(123));
    }

}
