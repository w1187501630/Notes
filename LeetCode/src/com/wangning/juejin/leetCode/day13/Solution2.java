package com.wangning.juejin.leetCode.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//18. 四数之和
class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int t) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        // 确定第一个数
        for (int i = 0; i < n; i++) {
            // 对第一个数进行去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 确定第二个数
            for (int j = i + 1; j < n; j++) {
                // 对第二个数进行去重
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // 确定第三个数和第四个数
                int L = j + 1;
                int R = n - 1;
                while (L < R) {

                    // 对第三个数进行去重
                    while (L > j + 1 && L < n && nums[L] == nums[L - 1]) L++;
                    if (L >= R) break;

                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == t) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        L++;
                    } else if (sum > t) {
                        R--;
                    } else if (sum < t) {
                        L++;
                    }
                }
            }
        }
        return res;
    }
}
