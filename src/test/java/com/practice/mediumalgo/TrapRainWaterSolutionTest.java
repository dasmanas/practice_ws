package com.practice.mediumalgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrapRainWaterSolutionTest {

    @Test
    void trap() {
        TrapRainWaterSolution trapRainWaterSolution = new TrapRainWaterSolution();
        System.out.println(trapRainWaterSolution.trap(new int[]{0,	1,	0,	2,	1,	0,	1,	3,	2,	1,	2,	1}));
    }
}