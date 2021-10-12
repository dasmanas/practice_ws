package com.practice.easyalgo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//10, 40, 90, 60 - 2
//50, 60, 150, 50, 40 - 4
//100, 100, 100 - 3

//10, 40, 90, 60 - 10->1, 40->1, 90->1, 60->1
//50, 60, 150, 50, 40 - 50->3, 60->1, 40->1
//100, 100, 100 - 0->3


//1<= payments[i]<=1000

public class Result {

    public static void main(String[] args){

        //10, 40, 90, 60
        List<Integer> case0 = new ArrayList(){{
            add(10);
            add(40);
            add(90);
            add(60);
        }};

        List<Integer> case1 = new ArrayList(){{
            add(50);
            add(60);
            add(150);
            add(50);
            add(40);
        }};

        List<Integer> case2 = new ArrayList(){{
            add(100);
            add(100);
            add(100);
        }};

        System.out.println("***Start of Case-0***");
        System.out.println(paymentPairs(case0));
        System.out.println("***Start of Case-1***");
        System.out.println(paymentPairs(case1));
        System.out.println("***Start of Case-2***");
        System.out.println(paymentPairs(case2));

    }


    public static long paymentPairs(List<Integer> payments){

        int len = payments.size();
        int count = 0;

        List<Integer> mods = new ArrayList<>();
        for(int payment: payments){
            mods.add(payment%100);
        }
        Map<Integer, Integer> pairs = new HashMap<>();
        for(int i=0; i<len; i++){
            if(!pairs.containsKey(mods.get(i))){
                pairs.put(mods.get(i), 1);
            } else {
                pairs.put(mods.get(i), pairs.get(mods.get(i))+1);
            }
        }
        System.out.println(pairs);

        for(int i=0; i<len; i++){
            int modulo = mods.get(i);
            int match = (100-modulo)%100;
            System.out.println("I am: "+ modulo);
            System.out.println("I need a match of: "+ match);

            if(pairs.containsKey(match)){
                if(pairs.get(modulo)>0){
                    pairs.put(modulo, pairs.get(mods.get(i))-1);
                }
                System.out.println("Match to whole number: "+ pairs.get(match));
                count = count + pairs.get(match);
                System.out.println("Count: "+ count);
            }
        }
        return count;
    }


}
