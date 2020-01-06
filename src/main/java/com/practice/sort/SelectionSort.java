package com.practice.sort;

public class SelectionSort {

    public void sort(int arr[]){

        int arrLen = arr.length;
        boolean swap;

        for (int i = 0; i < arrLen; i++) {
            swap = false;
            int minIndex = i;
            for (int j = i+1; j <arrLen ; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int minNumber = arr[minIndex];
            System.out.println("minNumber at current iteration: " + minNumber);
            if(minIndex==i){
                showArray(arr);
                System.out.println("Array is already sorted. Breaking from outer loop.");
                break;
            }
            arr[minIndex] = arr[i];
            arr[i] = minNumber;
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

        SelectionSort selectionSortObj = new SelectionSort();

        int arr[] = {2,8,5,3,9,4,1};

        selectionSortObj.showArray(arr);
        selectionSortObj.sort(arr);

    }
}
