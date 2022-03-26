package com.wangning.juejin.leetCode.day9;


//12. 整数转罗马数字
class Solution {

    // 初始化一个13种情况从大到小的键值对
    int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] str = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        StringBuffer romanNum = new StringBuffer();
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            String s = str[i];
            while (num >= n) {
                num -= n;
                romanNum.append(s);
            }
            if (num == 0) {
                break;
            }
        }
        return romanNum.toString();
    }
}