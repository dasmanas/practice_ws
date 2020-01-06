package com.practice.sort;

public class BubbleSort {

    public void sort(int arr[]) {
        int arrLen = arr.length;
        //Performance Optimization by introducing a swap variable
        boolean swap;
        for (int i = 0; i < arrLen - 1; i++) {
            swap = false;
            for (int j = 0 ; j < arrLen -i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
                showArray(arr);
            }
            //If there is no swap in the inner loop, it indicates array is already sorted.
            if (!swap){
                break;
            }
            System.out.println("Outer iteration #"+i+"completed");
        }
    }


    public void showArray(int arr[]) {
        int arrLen = arr.length;

        for (int i = 0; i < arrLen; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String args[]) {

        BubbleSort bubbleSortObj = new BubbleSort();

        int arr[] = {2, 8, 5, 3, 9, 4, 1};

        bubbleSortObj.showArray(arr);
        bubbleSortObj.sort(arr);

    }
}
