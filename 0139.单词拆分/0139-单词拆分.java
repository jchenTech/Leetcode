class Solution {
    /*
     * ��̬�滮˼·��Ҫʹ�ַ������Բ��Ϊ�ֵ��г��ֵĵ��ʣ����Դ���һ�����飬�洢
     * �ַ���ÿ��λ��֮ǰ�Ƿ�ɱ���֣����ж�iλ��֮ǰ���ִ��Ƿ�ɲ��ʱ����Ҫ����һ��ָ��j
     * ��������dp[i] = dp[j] && check[j..i]Ϊtrueʱ��˵��iλ��ʱ�ɲ�ֵġ�
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> wordSet = new HashSet<>(wordDict);
        
        dp[0] = true;//���ַ�������Ϊ��0Ϊtrue
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