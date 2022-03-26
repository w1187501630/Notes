package com.wangning.juejin.leetCode.day13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//17. 电话号码的字母组合
class Solution1 {
    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String ds) {
        int length = ds.length();

        List<String> res = new ArrayList<>();
        if (length == 0) return res;

        StringBuilder sb = new StringBuilder();
        dfs(ds, 0, length, sb, res);
        return res;
    }

    void dfs(String ds, int i, int n, StringBuilder sb, List<String> res) {
        if (i == n) {
            res.add(sb.toString());
            return;
        }

        char key = ds.charAt(i);

        String letters = map.get(key);
        for (int j = 0; j < letters.length(); j++){
            sb.append(letters.charAt(j));
            dfs(ds, i +1 , n, sb, res);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}