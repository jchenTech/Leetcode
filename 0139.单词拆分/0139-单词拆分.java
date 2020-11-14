class Solution {
    /*
     * 动态规划思路：要使字符串可以拆分为字典中出现的单词，可以创建一个数组，存储
     * 字符串每个位置之前是否可被拆分，在判断i位置之前的字串是否可拆分时，需要再用一个指针j
     * 遍历，当dp[i] = dp[j] && check[j..i]为true时，说明i位置时可拆分的。
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> wordSet = new HashSet<>(wordDict);
        
        dp[0] = true;//当字符串长度为零0为true
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}