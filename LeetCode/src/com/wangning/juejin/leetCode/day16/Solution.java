package com.wangning.juejin.leetCode.day16;

//26. 删除有序数组中的重复项
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
