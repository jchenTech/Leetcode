/** 采用深度优先搜索的方法从字符开头上下左右四个方向进行递归搜索
* 当越界和字符不匹配时，搜索失败，当成功搜到的字符与字符串长度相等时返回正确；
* 在此过程中，将已访问过的字符修改避免重复访问，在递归后再改回来
*/
class Solution {
    int m; //矩阵行数
    int n; //矩阵列数
    int length; //输入字符串长度
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        char[] words = word.toCharArray();
        length = words.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //先循环遍历找到与字符串首字符匹配，再深度优先搜索
                if (board[i][j] == words[0] && dfs(board, words, i, j, 0) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int x, int y, int index) {
        //当前元素的上下左右元素搜索失败条件：1.超出矩阵索引 2.没有与words中下一个字符匹配
        if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || board[x][y] != words[index]) {
            return false;
        }
        
        //当所有字符串中的字符都搜索完成后，返回正确
        if (index == length -1) {
            return true;
        }

        char temp = board[x][y];
        board[x][y] = '#'; //表示已访问过的字符

        boolean ans = dfs(board, words, x + 1, y, index + 1) ||  //右
        dfs(board, words, x, y + 1, index + 1) ||                //上
        dfs(board, words, x - 1, y, index + 1) ||               //左
        dfs(board, words, x, y - 1, index + 1);                 //下

        board[x][y] = temp;

        return ans;
    }
}