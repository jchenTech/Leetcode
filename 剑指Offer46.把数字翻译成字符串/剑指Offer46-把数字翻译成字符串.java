class Solution {
    //动态规划，类似与青蛙跳台阶，但是能不能跳两级要取决于两个数字是否在10到25之间
    //状态：dp[i]为i位及之前的翻译方法数量
    //状态转移方程：若i,i-1两位数字拼接可以翻译：dp[i] = dp[i-1] + dp[i-2]
    //若不能：dp[i] = dp[i-1]
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            String tmp = str.substring(i - 2, i);
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[str.length()];
    }
}