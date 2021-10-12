package com.practice.hardalgo.MaxProfit;

/*
startTime = 0
endTime = 10
dStarts = {0, 2, 3, 6, 7}
dEnds = {2, 7, 5, 12, 11}
dPays = {1, 5, 2, 4, 6}

0. skip all the deliveries before my start time
1. if no overlap then deliver that item
2.

maxPay = 7
*/

import java.util.Arrays;

public class Solution {

    public static void main(String[] args){

        Solution solution = new Solution();

    }

    int globalMaxPay = 0;

    class Delivery{
        int start;
        int end;
        int pay;
        int maxPay;
        boolean traversed;

        public Delivery(int start, int end, int pay){
            this.start = start;
            this.end = end;
            this.pay = pay;
        }
    }

    public int maxPay(int startTime, int endTime, int[] dStarts, int[] dEnds, int[] dPays){
        int len = dStarts.length;
        Delivery[] deliveries = new Delivery[len];
        int j=0;

        //Choosing delivery only falling inside schedule
        for(int i=0; i<len; i++){
            if(dStarts[i]>=startTime && dEnds[i]<=endTime){
                deliveries[j] = new Delivery(dStarts[i], dEnds[i], dPays[i]);
                j++;
            }
        }

        Arrays.sort(deliveries, (d1, d2) ->  Integer.compare(d1.start, d2.start) );


        for (int i=0; i<j; i++){
            if(!deliveries[i].traversed){
                recurse(deliveries, i, j, 0);
            }
        }

        return globalMaxPay;
    }


    public void recurse(Delivery[] deliveries, int index, int len, int pathPay){
        deliveries[index].traversed = true;
        pathPay = pathPay + deliveries[index].pay;
        if(pathPay > deliveries[index].maxPay){
            deliveries[index].maxPay = pathPay;
            globalMaxPay = Math.max(globalMaxPay, pathPay);
            for(int i=index+1; i<len; i++){
                if(deliveries[index].end <= deliveries[i].start){
                    recurse(deliveries, i, len, pathPay);
                }
            }
        }
    }


}
