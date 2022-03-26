package com.wangning.juejin.leetCode.day13;

import java.util.Arrays;

//16. 最接近的三数之和

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //初始化一个res
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int R = i + 1, L = nums.length - 1;
            while (R < L) {
                int sum = nums[R] + nums[L] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - res))
                    res = sum;
                if (sum > target)
                    L--;
                else if (sum < target)
                    R++;
                else
                    return res;
            }
        }
        return res;
    }
}
