class Solution {
    /** 二维数组中查找元素
     * 思路：利用二分查找的思想，从二维数组右上方进行查找，如果target值小，则col--；
     * 若target值大则row++；若相等则返回。
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