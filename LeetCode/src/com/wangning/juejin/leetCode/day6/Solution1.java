package com.wangning.juejin.leetCode.day6;


//8. 字符串转换整数 (atoi)
public class Solution1 {

    public int myAtoi(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int i = 0;  //字符下标
        int res = 0; //结果

        // 去除前导空格，全去掉了，就返回 0
        while (i < len && chars[i] == ' ') i++;
        if (i == len) return 0;

        // 标记是否存在负数符号
        boolean flag = false;
        if (chars[i] == '-') {
            i++;
            flag = true;
        } else if (chars[i] == '+') {
            i++;
        } else if (!Character.isDigit(chars[i])) {
            return 0;
        }

        while (i < len && Character.isDigit(chars[i])) {
            int num = chars[i++] - '0';
            //判断是否超出范围
            if (res > (Integer.MAX_VALUE - num) / 10) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + num;
        }
        return flag ? -res : res;
    }

}
