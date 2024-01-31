package com.practice.binary;

public class SumOfTwoWithOutPlusMinus {

    public static void main(String[] args) {
        System.out.println(getSum(2,3));
    }


    /*
    2 = 0010
    3 = 0011

    Sum is getting calculated using XOR
    Carry is getting calculated using and one left shift

    Keep adding carry to the sum until & unless Carry is 0;

     */


    public static int getSum(int a, int b) {
        while (b > 0) {
            int carry = (a & b);
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
