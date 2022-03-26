package com.wangning.juejin.leetCode.day19;

import java.util.ArrayDeque;
import java.util.Deque;

//32. 最长有效括号
class Solution1 {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0, j = -1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.addLast(i);

            } else {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                    int top = j;
                    if (!stack.isEmpty()) top = stack.peekLast();
                    res = Math.max(res, i - top);
                } else {
                    j = i;
                }
            }
        }
        return res;
    }
}
