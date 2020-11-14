class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }
    
    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        //ʧ��������Խ�����λ�ʹ���k����ڵ��ѷ���
        if (i > m - 1 || j > n -1 || sums(i, j) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        //���������˿��Դ��ĸ������ߣ�������������У�������ֻ��Ҫ���Һ������߾Ϳ�����
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
    }
    
    // ��������������λ��
    private int sums(int i, int j) {
        int sumi = 0;
        int sumj = 0;
        while (i != 0) {
            sumi += i % 10;
            i = i / 10; 
        }
        while (j != 0) {
            sumj += j % 10;
            j = j / 10; 
        }
        return sumi + sumj;
    }
}