package com.practice.easyalgo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciNumbersTest {

    @DisplayName("Test calculateFibonacci method")
    @Test
    void calculateFibonacci() {
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        System.out.println(fibonacciNumbers.calculateFibonacci(30));
        System.out.println(fibonacciNumbers.calculateFibonacciMemoizationTopDownHelper(500));

//        assertTrue(fibonacciNumbers.calculateFibonacci(5) == 5);
    }
}