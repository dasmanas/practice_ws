package com.practice.mediumalgo.ThreeSum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Solution {

    public static void main(String args[]) {
        Solution sol = new Solution();
        List<List<Integer>> lists = sol.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int curSum = 0;
        int curLevel = 0;
        List<Integer> temp = new ArrayList<>();
        return rSum(nums, 0, curLevel, curSum, temp);
    }

    public List<List<Integer>> rSum(int[] nums, int index, int curLevel, int curSum, List<Integer> elems) {
        int len = nums.length;
        int curNum = nums[index];
        curSum = curNum + curSum;

        List<Integer> newElems = new ArrayList<>();
        newElems.addAll(elems);
        newElems.add(curNum);

        if (curLevel == 2) {
            if (curSum == 0) {
                List<Integer> listNum = new ArrayList() {{
                    addAll(newElems);
                }};

                List<List<Integer>> listlistNum = new ArrayList() {{
                    add(listNum);
                }};
                return listlistNum;

            } else {
                return null;
            }
        } else {
            List<List<Integer>> acc = new ArrayList();
            for (int i = index + 1; i < len; i++) {
                List<List<Integer>> results = rSum(nums, i, curLevel + 1, curSum, newElems);
                if (results != null) {
                    for (Iterator<List<Integer>> it = results.iterator(); it.hasNext(); ) {
                        List<Integer> result = it.next();
                        acc.add(result);
                    }
                }
            }
            return acc;
        }
    }
}