package com.wangning.juejin.leetCode.day3;

//4. 寻找两个正序数组的中位数
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int x = n + m;

        if(x % 2 == 0){
            int l = findnum(nums1, 0, n - 1, nums2, 0, m - 1, x/2 );
            int r = findnum(nums1, 0, n - 1, nums2, 0, m - 1, x/2+1 );
            return (l + r) / 2.0 ;
        }

        return findnum(nums1, 0, n - 1, nums2, 0, m - 1, x/2+1);
    }

    private int findnum(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int x) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return findnum(nums2, start2, end2, nums1, start1, end1, x);
        if (len1 == 0) return nums2[start2 + x - 1];

        if (x == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, x / 2) - 1;
        int j = start2 + Math.min(len2, x / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return findnum(nums1, start1, end1, nums2, j + 1, end2, x - (j - start2 + 1));
        }
        else {
            return findnum(nums1, i + 1, end1, nums2, start2, end2, x - (i - start1 + 1));
        }
    }
}