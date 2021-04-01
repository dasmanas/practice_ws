/*
package com.practice.mediumalgo.CompareVersion;

class Solution1 {

    public static void main(String[] args) {
        Solution1 sol1 = new Solution1();

        System.out.println(sol1.compareVersion(
                "1.01",
                "1.001"));
    }

    public int compareVersion(String version1, String version2) {

        char[] vchar1 = version1.toCharArray(), vchar2 = version2.toCharArray();
        int v1Len = vchar1.length, v2Len = vchar2.length;
        int c1 = 0, c2 = 0;
        boolean v1LeadInd = true, v2LeadInd = true;
        char v1 = (char) 0, v2 = (char) 0;

        while (c1 < v1Len && c2 < v2Len) {
            v2 = vchar2[c2];
            v1 = vchar1[c1];

            if (v1 == v2) {
                c1++;
                c2++;
                if (v1 != '0') {
                    if (v1 == '.') {
                        v1LeadInd = true;
                        v2LeadInd = true;
                    } else {
                        v1LeadInd = false;
                        v2LeadInd = false;
                    }
                }
            } else {
                if (v1 == '0' && v1LeadInd == true) {
                    v1 = (char) 0;
                    c1++;
                } else {
                    v1LeadInd = false;
                }

                if (v2 == '0' && v2LeadInd == true) {
                    v2 = (char) 0;
                    c2++;
                } else {
                    v2LeadInd = false;
                }
            }
            if ((v1 == (char) 0) || (v2 == (char) 0)) {
                continue;
            } else {
                if (v1 > v2) {
                    return 1;
                } else if (v1 < v2) {
                    return -1;
                } else {
                    continue;
                }
            }
        }
        if (c1 == v1Len) {
            return -1;
        } else if (c2 == v2Len) {
            return 1;
        } else {
            return 0;
        }
    }

    public char nextValidNumber(int cur, char[] arr, boolean leadInd) {

        while (cur < arr.length) {
            if (arr[cur] == '0') {
                if (leadInd) {

                }
            } else if (arr[cur] == '.') {

            }

            if (leadInd) {
                if (arr[cur] == '0') {

                } else {
                    leadInd = false;
                }
            }

        }else if () {
        }


        if (leadInd && arr[cur] == '0') {
            cur++;
        } else {

        }
        if (v1 > v2) {
            return 1;
        } else if (v1 < v2) {
            return -1;
        } else {
            return 0;
        }
    }


}*/
