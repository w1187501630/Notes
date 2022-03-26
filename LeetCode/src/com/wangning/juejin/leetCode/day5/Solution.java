package com.wangning.juejin.leetCode.day5;

import java.util.ArrayList;
import java.util.List;

//6. Z 字形变换

class Solution {
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>(); //子串集合

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0;   //正向的时候的该字符所在行数
        int m = -1;  //用于行数变化 正向+1 反向-1
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1){
                m = - m;
            }
            i += m;
        }
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
