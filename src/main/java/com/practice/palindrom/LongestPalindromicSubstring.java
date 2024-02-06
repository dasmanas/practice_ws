package com.practice.palindrom;

import java.util.Arrays;

//https://leetcode.com/problems/longest-palindromic-substring/description/

//Finding Longest Palindromic Substring using Recursion and Dynamic Programming
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s==null || s.isEmpty()) return s;
        int len = s.length();
        String[][] memo = new String[len][len];
        return recurseLps(s.toCharArray(), 0, s.length()-1, memo);

    }

    public String recurseLps(char[] str, int start, int end, String[][] memo) {
        if(memo[start][end]!=null){
            return memo[start][end];
        }
        int len = end - start + 1;

        if (len == 1) return String.valueOf(str[start]);

        String bs = null;

        if (str[start] == str[end]) {
            if (len == 2) {
                //return new Pair(len, String.valueOf(Arrays.copyOfRange(str, start, start+2)));
                return String.valueOf(Arrays.copyOfRange(str, start, start+2));
            }
            //shrink the string from both sides
            bs = recurseLps(str, start + 1, end - 1, memo);
            if (bs.length() == end - start -1) return String.valueOf(str,start,bs.length()+2);

        }
        //shrink the string from right side
        String rs = recurseLps(str, start, end - 1, memo);
        //shrink the string from left side
        String ls = recurseLps(str, start + 1, end, memo);

        String resRsLs = rs.length() > ls.length() ? rs : ls;
        memo[start][end] = bs!=null && bs.length() > resRsLs.length()? bs : resRsLs;

        return memo[start][end];
    }


    //babad
    //cbbd
    public static void main(String[] args) {
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
        System.out.println(sol.longestPalindrome("ABDBAA"));
        System.out.println(sol.longestPalindrome("ABDBCA"));

//        System.out.println(sol.longestPalindrome("xaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaa"));
    }
}
