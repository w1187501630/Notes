package com.wangning.juejin.leetCode.day16;


//27. 移除元素
class Solution1 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
