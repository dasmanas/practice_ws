package com.practice.easyalgo.palindrome;

/**
 * Reverse a string and compare both the String
 */
public class Solution1 {

    public boolean checkPalindrome(String str){
        StringBuilder sb = new StringBuilder(str);
        String reverseStr = sb.reverse().toString();
        return str.equals(reverseStr);
    }
}
