class Solution {
    public double[] dicesProbability(int n) {
        double[] res = new double[6*n - n + 1];//n个骰子出现所有点数和的结果为6*n-n+1
        int[][] dp = new int[n + 1][6*n + 1];//dp[i][j]表示i个骰子的点数和为j的出现次数
        
        //初始化dp数组，当只有一个骰子的时候，出现的所有点数次数都为1
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        //i为骰子数量，j为点数为j，k为1个骰子出现的点数
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                //dp[i][j] += dp[i - 1][j - k]; k属于[1,6]
                for (int k = 1; k <= 6; k++) {
                    //j-k必须大于0
                    if (j - k <= 0) break;
                    dp[i][j] += dp[i - 1][j - k];
                }
            } 
        }
        
        double total = Math.pow(6, n);

        for (int i = n; i <= 6 * n; i++) {
            res[i - n] = dp[n][i] / total;
        }

        return res;
    }
}