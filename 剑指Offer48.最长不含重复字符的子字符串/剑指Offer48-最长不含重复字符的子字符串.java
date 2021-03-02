class Solution {
    //��̬�滮+��ϣ��
    //dp[i]Ϊ����iλ�ĵĲ����ظ��ַ��ĳ��ȣ��ù�ϣ���ÿ���ַ������һ�δ洢����λ��
    //����ϣ����s.charAt[i]��dp[i]=dp[i-1]+1;
    //����ϣ�������dp[i]=i-map.get(s.charAt[i]);
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
                if (dp[i - 1] < i - lastIndex) {//i��lastIndex�䲻���������ظ��ַ�
                    dp[i] = dp[i - 1] + 1;
                }else {//i��lastIndex����������ظ��ַ�
                    dp[i] = i - lastIndex;
                }
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}