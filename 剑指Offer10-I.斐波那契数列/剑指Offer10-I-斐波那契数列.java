class Solution {
    //dp[i] = dp[i - 1] + dp[i -2];
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int pre1 = 0, pre2 = 1;
        for (int i = 2; i <= n; i++) {
            int cur = (pre1 + pre2) % 1000000007;
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }
}