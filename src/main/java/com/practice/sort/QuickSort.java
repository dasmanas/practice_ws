package com.practice.sort;

public class QuickSort {

    void sort(int arr[], int l, int h){

        int pi = partition(arr, l, h);

        sort(arr, l, pi-1);
        sort(arr, pi+1, h);
    }


    int partition(int arr[], int l, int h){
        int pivot = (l + h) / 2;
        int left = l;
        int right = h;

        while(left < right){
            while(arr[left] <= arr[pivot] && left < right){
                left++;
            }
            while(arr[pivot] <= arr[right] && left < right){
                right--;
            }
            //swap
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        return 0;
    }



}
