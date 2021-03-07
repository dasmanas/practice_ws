package com.practice.mediumalgo;

/**
 * You are given an integer array nums sorted in ascending order, and an integer target.
 * <p>
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,3,4,5,6,7,8,9,10,11,12]
 * might become [4,5,6,7,8,9,10,11,12,0,1,2,3]).
 * <p>
 * If target is found in the array return its index, otherwise, return -1.
 */
public class SearchRotatedSortedArraySolution {

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[start] <= nums[mid]) {
                    if (target >= nums[start] && target < nums[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else if (nums[mid] >= nums[end]) {
                    if (target > nums[mid] && target <= nums[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
