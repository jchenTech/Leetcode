class Solution {
    /** ��ά�����в���Ԫ��
     * ˼·�����ö��ֲ��ҵ�˼�룬�Ӷ�ά�������Ϸ����в��ң����targetֵС����col--��
     * ��targetֵ����row++��������򷵻ء�
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            if (target < matrix[row][col]) {
                col--;
            }else if (target > matrix[row][col]) {
                row++;
            }else {
                return true;
            }
        }
        return false;
    }
}