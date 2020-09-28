package com.practice.ds.array;

public class ArrayRotation {

    void leftRotate(int arr[], int shiftBy, int n){

        int gcdNum = gcd(n , shiftBy);

        for (int i = 0; i < gcdNum; i++) {

        }

    }

    private int gcd(int a, int b){
        int r = a % b;
        if(r==0)
            return b;
        else
            return gcd(b, r);
    }


    public static void main(String[] args)
    {
        ArrayRotation rotate = new ArrayRotation();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12 };
        rotate.leftRotate(arr, 2, 7);
//        rotate.printArray(arr, 7);
    }
}
