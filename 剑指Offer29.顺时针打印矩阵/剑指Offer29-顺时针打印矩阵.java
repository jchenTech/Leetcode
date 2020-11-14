class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int l = 0;
        int t = 0;
        int x = 0;
        int r = matrix[0].length - 1;
        int b = matrix.length - 1;
        int[] res = new int[(b + 1) * (r + 1)];
        while(true) {
            //������
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i];
            if (++t > b) break;

            //���ϵ���
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r];
            if (l > --r) break;

            //���ҵ���
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i];
            if (t > --b) break;

            //���µ���
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l];
            if (++l > r) break;
        } 
        return res;
    }
}