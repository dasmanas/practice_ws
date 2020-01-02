package com.practice.search;

public class JumpSearch {

    int jumpSearch(int [] arr, int findNum){
        int n = arr.length;

        int jumpStep = (int)Math.floor(Math.sqrt(n));

        return 0;
    }

    public static void main(String [ ] args)
    {
        JumpSearch jumpSearch = new JumpSearch();
        int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};
        int x = 55;

        // Find the index of 'x' using Jump Search
//        int index = jumpSearch(arr, x);

        // Print the index where 'x' is located
//        System.out.println("\nNumber " + x +
//                " is at index " + index);
    }

}
