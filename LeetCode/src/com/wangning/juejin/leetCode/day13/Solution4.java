package com.wangning.juejin.leetCode.day13;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


//20. 有效的括号
class Solution4 {
    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
