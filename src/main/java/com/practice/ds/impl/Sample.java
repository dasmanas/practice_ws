package com.practice.ds.impl;

import java.util.*;

public class Sample {
    public static void main(String[] args){
        LinkedList list = new LinkedList();


        Stack<Integer> stack = new Stack<>();
        stack.peek();
        stack.pop();
        stack.push(1);

        while(!stack.empty()){
            System.out.println(stack.pop());
        }

        Set<String> hashSet = new HashSet<>();
        hashSet.add("Geeks");
        hashSet.add("For");
        hashSet.add("Geeks");
        hashSet.add("Example");
        hashSet.add("Set");

        for (String s: hashSet){
            System.out.println(s);
        }

        int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
        Arrays.sort(arr);

        Arrays.copyOfRange(arr, 1, arr.length-1);

        String s  = new String("manas");
        s.toCharArray();

        Map<String, String> m = new HashMap<>();
        m.put("1", "manas");
        m.put("2", "das");



        int [][] directions = {{1,0},
                {-1,0},
                {0,-1},
                {0,1}};

        for (int[] direction: directions){

        }




    }
}
