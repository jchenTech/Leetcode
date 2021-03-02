class Solution {
    //dp[i]表示以prices[i]结尾的子数组的最大利润
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] dp = new int[prices.length];
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            }else {
                dp[i] = prices[i] - min;
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}