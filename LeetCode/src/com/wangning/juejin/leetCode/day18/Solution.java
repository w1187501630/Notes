package com.wangning.juejin.leetCode.day18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//30. 串联所有单词的子串

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();

        // 统计 words 中「每个目标单词」的出现次数
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int length = s.length();
        int m = words.length;
        int n = words[0].length();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < length - m * n + 1; i++){
            Map<String, Integer> cur = new HashMap<>();
            int index = i;
            while(index < i + m * n){
                String curWord = s.substring(index, index + n);
                if(!map.containsKey(curWord) || cur.get(curWord) == map.get(curWord)){
                    break;
                }
                cur.put(curWord, cur.getOrDefault(curWord, 0) + 1);
                index += n;
            }
            if(index == i + m * n){
                res.add(i);
            }
        }
        return res;
    }
}
