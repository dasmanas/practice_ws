package com.practice.search;

public class BinarySearch {

    int binarySearch(int arr[], int start, int end, int findNum){
        int mid = (start + end) / 2;
        if(start<=end){
            if (arr[mid]==findNum){
                return mid;
            } else if (arr[mid] < findNum) {
                return binarySearch(arr, mid+1, end, findNum);
            } else {
                return binarySearch(arr, start, mid -1, findNum);
            }
        } else {
            return -1;
        }
    }

    public static void main(String args[])
    {
        BinarySearch binarySearch = new BinarySearch();
        int arr[] = { 1, 2, 3, 5, 8, 13, 21, 44 };
        int n = arr.length;
        int x = 40;
        int result = binarySearch.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " + result);
    }
}
