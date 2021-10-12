package com.practice.ds.impl;

import java.util.*;

public class Sample {
    public static void main(String[] args){
        LinkedList list = new LinkedList();


        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.peek();
        stack.pop();


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

        //null character
        arr[0] = (int) 0;

        Arrays.copyOfRange(arr, 1, arr.length-1);

        String s  = new String("manas");
        s.toCharArray();

        Map<String, String> m = new HashMap<>();
        m.put("1", "manas");
        m.put("2", "das");
        m.computeIfAbsent("3", key -> key+"0");





        int [][] directions = {{1,0},
                {-1,0},
                {0,-1},
                {0,1}};

        for (int[] direction: directions){

        }

        Queue<Integer> minHeap = new PriorityQueue();
        Queue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());

        minHeap.offer(1);
        minHeap.offer(3);
        minHeap.offer(2);

        System.out.println("minHeap peek: " + minHeap.peek());
        System.out.println("minHeap poll: " + minHeap.poll());
        System.out.println("minHeap poll: " + minHeap.poll());
        System.out.println("minHeap poll: " + minHeap.poll());


        int[][] a2i = {
                {1, 5},
                {13, 12},
                {12, 11},
                {20, 2},
                {14, 10}
        };
        System.out.println(Arrays.deepToString(a2i));
        /*Arrays.sort(ai, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });*/
        Arrays.sort(a2i, (int[] o1, int[] o2) -> Integer.compare(o1[0],o2[0]));
        System.out.println(Arrays.deepToString(a2i));
        System.out.println(Arrays.deepToString(Arrays.copyOfRange(a2i,0,2)));

        int[] ai = {1, 13, 12, 20, 14};
        System.out.println(Arrays.toString(ai));
        Arrays.sort(ai);
        System.out.println(Arrays.toString(ai));
        System.out.println(Arrays.toString(Arrays.copyOfRange(ai,0,2)));


        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        queue.poll();
        queue.peek();



    }
}
