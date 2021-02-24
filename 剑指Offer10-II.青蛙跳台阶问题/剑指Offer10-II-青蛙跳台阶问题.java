class Solution {
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int pre1 = 1;
        int pre2 = 1;
        for (int i = 2; i <= n; i++) {
            int cur = (pre1 + pre2) % 1000000007;
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }
}