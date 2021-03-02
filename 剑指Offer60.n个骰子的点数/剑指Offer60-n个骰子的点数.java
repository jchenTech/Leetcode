class Solution {
    public double[] dicesProbability(int n) {
        double[] res = new double[6*n - n + 1];//n�����ӳ������е����͵Ľ��Ϊ6*n-n+1
        int[][] dp = new int[n + 1][6*n + 1];//dp[i][j]��ʾi�����ӵĵ�����Ϊj�ĳ��ִ���
        
        //��ʼ��dp���飬��ֻ��һ�����ӵ�ʱ�򣬳��ֵ����е���������Ϊ1
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        //iΪ����������jΪ����Ϊj��kΪ1�����ӳ��ֵĵ���
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                //dp[i][j] += dp[i - 1][j - k]; k����[1,6]
                for (int k = 1; k <= 6; k++) {
                    //j-k�������0
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