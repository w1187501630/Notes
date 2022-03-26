package com.wangning.juejin.leetCode.day16;

//28. 实现 strStr()
class Solution2 {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();

        for (int i = 0; i + len2 <= len1; i++) {
            boolean flag = true;
            for (int j = 0; j < len2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}