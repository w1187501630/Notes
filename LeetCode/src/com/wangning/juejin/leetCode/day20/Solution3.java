package com.wangning.juejin.leetCode.day20;

//36. 有效的数独
class Solution3 {
    public boolean isValidSudoku(char[][] board) {

        //记录每行，列 ，每个方块出现数字的情况
        boolean[][] row = new boolean[9][9];
        boolean[][] colnum = new boolean[9][9];
        boolean[][] area = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int c = board[i][j] - '1';
                int idx = i / 3 * 3 + j / 3;
                if (!row[i][c] && !colnum[j][c] && !area[idx][c]) {
                    row[i][c] = colnum[j][c] = area[idx][c] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
