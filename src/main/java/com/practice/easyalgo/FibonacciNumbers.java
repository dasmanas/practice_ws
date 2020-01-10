package com.practice.easyalgo;

import java.lang.reflect.Array;

public class FibonacciNumbers {

    /**
     *                         f(5)
     *                      /        \
     *                    /             \
     *                f(4)               f(3)
     *               /   \              /    \
     *             /     \            /       \
     *          f(3)  f(2)           f(2)      f(1)
     *         /  \   /  \         /  \
     *       /    \  /   \      f(1) f(0)
     *    f(2) f(1) f(1)f(0)
     *   /   \
     *  f(1) f(0)
     */


    public int calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }

    private long calculateFibonacciMemoizationTopDown(int n, long cache[]) {
        if (n <= 1) {
            return cache[n];
        } else{
            if(cache[n]!=0){
                return cache[n];
            }else{
                cache[n] = calculateFibonacciMemoizationTopDown(n - 1, cache) + calculateFibonacciMemoizationTopDown(n - 2, cache);
                return cache[n];
            }
        }
    }

    public long calculateFibonacciMemoizationTopDownHelper(int n){
        long cache[] = new long[n+1];
        cache[0] = 0;
        cache[1] = 1;

        return calculateFibonacciMemoizationTopDown(n, cache);
    }






}
