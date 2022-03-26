package com.wangning.juejin.leetCode.day20;

//33. 搜索旋转排序数组
class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) return -1;
        if (length == 1) return nums[0] == target ? 0 : -1;

        //找旋转点
        int l = 0, r = length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        // 通过和 nums[0] 进行比较，判断 target 是在旋转点的左边还是右边
        if (target >= nums[0]) {
            l = 0;
        } else {
            l = l + 1;
            r = length - 1;
        }
        // 找 target
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return nums[r] == target ? r : -1;
    }
}
