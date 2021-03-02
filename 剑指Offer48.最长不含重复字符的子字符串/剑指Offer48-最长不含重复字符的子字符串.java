class Solution {
    //动态规划+哈希表
    //dp[i]为含第i位的的不含重复字符的长度，用哈希表存每个字符的最近一次存储索引位置
    //当哈希表不含s.charAt[i]：dp[i]=dp[i-1]+1;
    //当哈希表包含：dp[i]=i-map.get(s.charAt[i]);
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        map.put(s.charAt(0), 0);
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                dp[i] = dp[i - 1] + 1;
            }else {
                int lastIndex = map.get(s.charAt(i));
                if (dp[i - 1] < i - lastIndex) {//i和lastIndex间不存在其他重复字符
                    dp[i] = dp[i - 1] + 1;
                }else {//i和lastIndex间存在其他重复字符
                    dp[i] = i - lastIndex;
                }
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}