package com.practice.easyalgo.palindrome;

import java.util.Arrays;

public class Solution2 {

    public boolean checkPalindromeHelper(String str){
        char[] strArr = str.toCharArray();
        return checkPalindrome(strArr);
    }


    public boolean checkPalindrome(char[] str) {
        int strLen = str.length;
        if (strLen == 0 || strLen == 1) {
            return true;
        } else {
            if (str[0] == str[strLen - 1]) {
                return checkPalindrome(Arrays.copyOfRange(str, 1, strLen-1));
            } else {
                return false;
            }
        }
    }
}
