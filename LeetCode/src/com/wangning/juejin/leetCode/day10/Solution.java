package com.wangning.juejin.leetCode.day10;

import java.util.HashMap;
import java.util.Map;
//13. 罗马数字转整数
//https://leetcode-cn.com/problems/roman-to-integer/
class Solution {

    Map<String, Integer> map = new HashMap<String,Integer>() {{
        put("M", 1000);
        put("D", 500);
        put("C", 100);
        put("L", 50);
        put("X", 10);
        put("V", 5);
        put("I", 1);
    }};

    public int romanToInt(String s) {
        int sum = 0;
        int res = map.get(s.substring(0, 1));
        for (int i = 1; i < s.length(); i++) {
            int num = map.get(s.substring(i, i + 1));
            if (res < num) {
                sum -= res;
            } else {
                sum += res;
            }
            res = num;
        }
        sum += res;
        return sum;
    }
}