package com.practice.mediumalgo;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStrWoRepeatingChar {

    public int lengthOfLongestSubStr(String s){
        int windowStart = 0;
        int windowEnd = 0;
        int max = 0;
        Set<Character> charSet = new HashSet<Character>();

        while(windowEnd < s.length()){
            Character ch = s.charAt(windowEnd);
            if(!charSet.contains(ch)){
                charSet.add(ch);
                windowEnd ++;
                max = Math.max(charSet.size(), max);
            }else {
                charSet.remove(s.charAt(windowStart));
                windowStart ++;
            }
            System.out.printf("windowStart: %d%n", windowStart);
            System.out.printf("windowEnd: %d%n", windowEnd);
            System.out.println(charSet);
        }
        return max;
    }
}
