class Solution {
    //丑数只能有由比其小的丑数乘2，3或5组成，因此可以用动态规划,dp[i]表示第i个丑数
    //由于第i位丑数可以由xa*2,xb*3或xc*5组成，但是其是离xi-1最近的数，所以其为这三个中的最小值
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(dp[a] * 2, dp[b] * 3), dp[c] * 5);
            dp[i] = min;
            if (dp[a] * 2 == min) a++;
            if (dp[b] * 3 == min) b++;
            if (dp[c] * 5 == min) c++;
        }
        return dp[n - 1];
    }
}