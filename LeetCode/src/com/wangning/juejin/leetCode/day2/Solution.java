package com.wangning.juejin.leetCode.day2;


import java.util.HashMap;

//3. 无重复字符的最长子串

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> map =  new HashMap<>();

        //记录结果 即窗口的最大长度
        int resultMax = 0;

        //窗口最开始的左边界和右边界
        int start = 0;
        int end = 0;
        for ( end = 0;  end < s.length() ; end ++) {

            if (map.containsKey(s.charAt(end))){
                //窗口内存在重复的值时 移动窗口的左边界start
                start  = Math.max(start,map.get(s.charAt(end)) + 1);
            }

            map.put(s.charAt(end),end);

            resultMax = Math.max(resultMax,end - start + 1 );

        }
        return resultMax;
    }
}