package com.wangning.juejin.leetCode.day20;

//35. 搜索插入位置
public class Solution2 {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        int res = length;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
