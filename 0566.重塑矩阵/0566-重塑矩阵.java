class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || (nums.length * nums[0].length) != (r * c)) {
            return nums;
        }

        int row = 0;
        int col = 0;
        int[][] res = new int[r][c];
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[row][col] = nums[i][j];
                if (col == c - 1) {
                    row++;
                    col = 0;
                }else {
                    col++;
                }
            }
        }
        return res;
    }
}