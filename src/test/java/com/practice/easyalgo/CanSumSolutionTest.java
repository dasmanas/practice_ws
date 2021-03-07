package com.practice.easyalgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanSumSolutionTest {

    @Test
    void canSum() {
        CanSumSolution canSumSolution = new CanSumSolution();
        int target = 11;
        int[] candidates = {3,4,5,7,9,12};

        System.out.println(canSumSolution.canSum(target, candidates));

    }
}