class Solution {
    //动态规划dp[i]为i位及之前数组中子数组和的最大值
    //动态转移方程：dp[i]=Math.max(nums[i], dp[i-1] + nums[i])
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}