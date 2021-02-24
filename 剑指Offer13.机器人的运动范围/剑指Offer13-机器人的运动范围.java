class Solution {
    /**�����������+����
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
        //��ֹ������1����������m��n����߽� 2��i,j����λ����Ӵ���k 3����ǰԪ���Ѿ����ʹ�
        if (i >= m || j >= n || si + sj > k || visited[i][j] == true) {
            return 0;
        }
        visited[i][j] = true;
        //���¡��������������˵��˶���ΧΪ0,0�õ�����·����ҷ����˶���Χ���
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