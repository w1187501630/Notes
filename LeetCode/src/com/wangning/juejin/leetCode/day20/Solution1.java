package com.wangning.juejin.leetCode.day20;

//34. 在排序数组中查找元素的第一个和最后一个位置
class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int length = nums.length;
        if (length == 0) return ans;

        int l = 0, r = length - 1;
        // 查找第一个位置
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        // 不存在 直接返回
        if (nums[l] != target) {
            return ans;
        }
        //查找最后一个位置
        ans[0] = l;

        l = 0;
        r = length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        ans[1] = l;

        return ans;
    }
}
