class Solution {
    /**
    * 从矩阵的右上角进行遍历，当target大于当前元素，则往左遍历，若小于，则向下遍历
    */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            }else if (matrix[i][j] < target) {
                i++;
            }else {
                return true;
            }
        }
        return false;
        
    }
}