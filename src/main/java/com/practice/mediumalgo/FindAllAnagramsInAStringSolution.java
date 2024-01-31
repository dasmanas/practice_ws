package com.practice.mediumalgo;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAStringSolution {

    public static void main(String[] args){
        FindAllAnagramsInAStringSolution sol = new FindAllAnagramsInAStringSolution();
        List<Integer> anagrams = sol.findAnagrams("cbaebabacd", "abc");

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s==null || s.isEmpty() || p == null || p.isEmpty() || s.length() < p.length()){
            return new ArrayList<Integer>();
        }
        // a to z 26 letters
        int[] chMap = new int[26];
        for(char ch: p.toCharArray()){
            chMap[ch - 'a'] += 1;
        }

        int lp=0,rp=0;
        char[] schar = s.toCharArray();
        for(rp=0; rp<s.length()-1; rp++){
            if(chMap[schar[rp] - 'a'] > 0 ){
                chMap[schar[rp] - 'a'] -= 1;
                if(rp-lp == p.length()-1){
                    result.add(lp);
                    chMap[schar[lp] - 'a'] += 1;
                    lp++;
                }
            } else {
                while (lp <= rp) {
                    if(lp!=rp){
                        chMap[schar[lp] - 'a'] += 1;
                    }
                    lp++;
                }
            }

        }
        return result;
    }

}
