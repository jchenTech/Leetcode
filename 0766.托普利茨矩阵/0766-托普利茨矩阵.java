class Solution {
    /**.
    * 检查相邻右上元素
    * 若矩阵从左上到右下的对角线元素相等，那么我们可以得出规律：
    * 矩阵中任意元素若上方和右方有相邻元素时，相邻元素相等，则为托普利茨矩阵 
    * 因此遍历时，除去第一行和最后一列进行遍历
    */
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && j < matrix[0].length - 1 && matrix[i - 1][j] != matrix[i][j + 1]) {
                    return false;
                }else{
                    continue;
                }
            }
        }
        return true;
    }
}