package com.wangning.juejin.leetCode.day8;

// 11 成最多的水
class Solution {
//    public int maxArea(int[] height) {
//        int length = height.length;
//        int result = 0;
//        for (int i = 0; i < length; i++) {
//            for (int j = i + 1; j < length; j++) {
//                int w = j - i;
//                int h = Math.min(height[i], height[j]);
//                result = Math.max(w * h, result);
//            }
//        }
//        return result;
//    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            int tol = Math.min(height[l], height[r]) * (r - l);
            res = Math.max(res, tol);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return res;
    }

}