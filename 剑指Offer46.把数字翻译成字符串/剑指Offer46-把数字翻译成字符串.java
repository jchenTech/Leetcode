class Solution {
    //��̬�滮��������������̨�ף������ܲ���������Ҫȡ�������������Ƿ���10��25֮��
    //״̬��dp[i]Ϊiλ��֮ǰ�ķ��뷽������
    //״̬ת�Ʒ��̣���i,i-1��λ����ƴ�ӿ��Է��룺dp[i] = dp[i-1] + dp[i-2]
    //�����ܣ�dp[i] = dp[i-1]
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