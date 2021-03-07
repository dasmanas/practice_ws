package com.practice.easyalgo;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> grpAnagrams = new ArrayList<>();
        Map<String, List<String>> mapGrpAnagrams = new HashMap<>();

        for(String s: strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(mapGrpAnagrams.containsKey(key)){
                mapGrpAnagrams.get(key).add(s);
            } else {
                List list = new ArrayList<String>();
                list.add(s);
                mapGrpAnagrams.put(key, list);
            }
        }
        Iterator<Map.Entry<String, List<String>>> itr = mapGrpAnagrams.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<String, List<String>> entry = itr.next();
            grpAnagrams.add(entry.getValue());
        }
        return grpAnagrams;
    }
}