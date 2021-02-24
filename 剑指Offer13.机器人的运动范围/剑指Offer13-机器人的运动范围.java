class Solution {
    /**深度优先搜索+回溯
    */
    int m, n, k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        visited = new boolean[m][n];
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        int si = sums(i);
        int sj = sums(j);
        //终止条件：1、索引超出m×n方格边界 2、i,j的数位和相加大于k 3、当前元素已经访问过
        if (i >= m || j >= n || si + sj > k || visited[i][j] == true) {
            return 0;
        }
        visited[i][j] = true;
        //向下、右搜索，机器人的运动范围为0,0该点和其下方和右方的运动范围相加
        return 1 + dfs(i + 1, j) + dfs(i, j + 1);
    }

    private int sums(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum;
    }
}