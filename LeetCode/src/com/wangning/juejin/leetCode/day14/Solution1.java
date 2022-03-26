package com.wangning.juejin.leetCode.day14;

import java.util.ArrayList;
import java.util.List;

//22. 括号生成
class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        dfs(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public void dfs(List<String> ans, StringBuilder cur, int l, int r, int len) {
        if (cur.length() == len * 2) {
            ans.add(cur.toString());
            return;
        }
        if (l < len) {
            cur.append('(');
            dfs(ans, cur, l + 1, r, len);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (r < l) {
            cur.append(')');
            dfs(ans, cur, l, r + 1, len);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
