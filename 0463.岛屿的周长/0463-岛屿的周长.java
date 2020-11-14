class Solution {
    /*
    * 遍历矩阵中为1的元素，计算岛屿周长时，当其上下左右周围有i个1，则他需要计算的周长为4-i
    */
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int squarePerimeter = 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        squarePerimeter--;
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        squarePerimeter--;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        squarePerimeter--;
                    }
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                        squarePerimeter--;
                    }
                    perimeter += squarePerimeter;
                }
            }
        }
        return perimeter;
    }
}