class Solution {
    //���ֲ���
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row-1][col-1];
        while (left < right) {
            // ÿ��ѭ������֤��KС������start~end֮�䣬��start==end����kС��������start
            int mid = (left + right) / 2;
            // �Ҷ�ά������<=mid��Ԫ���ܸ���
            int count = findNotBiggerThanMid(matrix, mid, row, col);
            if (count < k) {
                // ��kС�������Ұ벿�֣��Ҳ�����mid
                left = mid + 1;
            }else {
                // ��kС��������벿�֣����ܰ���mid
                right = mid;
            }
        }
        return right;
    }

    private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        // ����Ϊ��λ�ң��ҵ�ÿһ�����һ��<=mid������֪��ÿһ���ж��ٸ���<=mid
        int i = 0;
        int j = col-1;
        int count = 0;
        while (i < row && j >=0) {
            if (matrix[i][j] <= mid) {
                count += j+1;
                i += 1;
            }else {
                j -= 1;
            }
        }
        return count;
    }
}