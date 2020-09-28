package com.practice.mediumalgo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubStrWoRepeatingCharTest {

    @DisplayName("Test Length of Longest Substring without repeating character")
    @Test
    void lengthOfLongestSubStr() {
        LongestSubStrWoRepeatingChar longestSubStrWoRepeatingChar = new LongestSubStrWoRepeatingChar();
        int i = longestSubStrWoRepeatingChar.lengthOfLongestSubStr("abcabcdefghtydsfasdoenveev");
        System.out.printf("Length of longest substring is %d%n", i);
    }
}