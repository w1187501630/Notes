package com.wangning.juejin.leetCode.day7;

//9. 回文数

class Solution {
    public boolean isPalindrome(int x) {

        // 负数和 10的倍数的 直接返回
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNum = 0;
        while (x > revertedNum) {
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;
        }

        // 回文数 长度奇偶两种情况
        return x == revertedNum || x == revertedNum / 10;
    }
}