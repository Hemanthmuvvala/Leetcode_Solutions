// Last updated: 7/16/2026, 9:26:43 AM
1class Solution {
2    public boolean exist(char[][] board, String word) {
3        int row = board.length;
4        int col = board[0].length;
5
6        for (int i = 0; i < row; i++) {
7            for (int j = 0; j < col; j++) {
8                if (board[i][j] == word.charAt(0) && backtrack(board, 0, word, i, j)) {
9                    return true;
10                }
11            }
12        }
13        return false;
14    }
15
16    private static boolean backtrack(char[][] board, int count, String word, int row, int col) {
17        int n = board.length;
18        if (count == word.length()) {
19            return true;
20        }
21
22        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
23                || board[row][col] != word.charAt(count)){
24            return false;
25                }
26        char temp = board[row][col];
27        board[row][col] = ' ';
28        boolean found = backtrack(board, count + 1, word, row + 1, col)
29                || backtrack(board, count + 1, word, row - 1, col) || backtrack(board, count + 1, word, row, col + 1)
30                || backtrack(board, count + 1, word, row , col - 1);
31        board[row][col] = temp;
32        return found;
33    }
34}