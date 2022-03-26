package com.wangning.juejin.leetCode.day19;

//31. 下一个排列
class Solution {
    public void nextPermutation(int[]
                                        nums) {
        int len = nums.length - 2;

        //判断当前是否为降序的最大排列
        while (len >= 0 && nums[len] >= nums[len + 1]) {
            len--;
        }

        if (len >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[len] >= nums[j]) {
                j--;
            }
            swap(nums, len, j);
        }
        // 反转后半段
        reverse(nums, len + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
