class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while(row < matrix.length && col >=0) {
            if (matrix[row][col] > target) {
                col -= 1;
            }else if (matrix[row][col] < target){
                row += 1;
            }else {
                return true;
            }
        }
        return false; 
    }
}