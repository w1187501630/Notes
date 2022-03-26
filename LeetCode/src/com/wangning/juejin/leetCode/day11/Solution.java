package com.wangning.juejin.leetCode.day11;


//最长公共前缀
//以第一个字符串作为标准，
// 依次遍历字符串数组中的欺负每个字符串，对于每个遍历到的字符串，更新最长公共前缀
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String resStr = strs[0];
        for (int i = 0 ; i < strs.length;i++){
            int j = 0;
            for (; j <resStr.length() && j < strs[i].length();j++){
                if (resStr.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            resStr = resStr.substring(0,j);
        }
        return resStr;
    }
}