package com.wangning.juejin.leetCode.day17;



//29. 两数相除
class Solution {

    public static int divide(int dividend, int divisor) {
        long result = 0;
        long x = dividend;
        long y = divisor;

        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }

        boolean flag = (x < 0 && y > 0) || (x > 0 && y < 0);
        //将所有的负数变成正数，考虑一种情况
        if (x < 0) {
            x = -x;
        }
        if (y < 0) {
            y = -y;
        }
        // 一半情况 二分
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = left + right + 1 >> 1;
            long  quicknum = quickAdd(mid, y);
            if (quicknum <= x) {
                // 相乘结果不大于x，左指针右移
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        result = flag ? -left : left;

        // 判断是否溢出
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int)result;
    }

    public static long quickAdd(long a, long b) {
        long result = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                // 当前最低位为1，结果里加上a
                result += a;
            }
            // 被乘数右移1位，相当于除以2
            b >>= 1;
            // 乘数倍增，相当于乘以2
            a += a;
        }

        return result;
    }
}
