class Solution {
    //深度搜索+剪枝
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        //终止条件：(1) 行或列索引越界 或 (2) 当前矩阵元素与目标字符不同
        //(3) 当前矩阵元素已访问过（(3)可合并至(2)）
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[k]) {
            return false;
        }
        if (k == words.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, words, i - 1, j, k + 1)
        || dfs(board, words, i + 1, j, k + 1) 
        || dfs(board, words, i, j - 1, k + 1) 
        || dfs(board, words, i, j + 1, k + 1);
        board[i][j] = words[k];
        return res;
    }
}