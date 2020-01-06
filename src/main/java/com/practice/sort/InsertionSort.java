package com.practice.sort;

public class InsertionSort {

    public void sort(int arr[]){
        int arrLength = arr.length;

        for (int i = 0; i < arrLength; i++) {

            int valueOnLeftShift = arr[i];
            int compareIndex = i-1;

            while (compareIndex >= 0 && (valueOnLeftShift < arr[compareIndex])){
                arr[compareIndex+1] = arr[compareIndex];
                arr[compareIndex] = valueOnLeftShift;
                compareIndex --;
            }
            showArray(arr);
        }
    }

    public void showArray(int arr[]){
        int arrLen = arr.length;
        for (int i = 0; i < arrLen; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }


    public static void main(String args[]){
        InsertionSort insertionSortObj = new InsertionSort();

        int arr[] = {2, 8, 5, 3, 9, 4};

        insertionSortObj.showArray(arr);
        insertionSortObj.sort(arr);
    }
}
