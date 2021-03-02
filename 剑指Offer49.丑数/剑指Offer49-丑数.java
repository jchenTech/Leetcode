class Solution {
    //����ֻ�����ɱ���С�ĳ�����2��3��5��ɣ���˿����ö�̬�滮,dp[i]��ʾ��i������
    //���ڵ�iλ����������xa*2,xb*3��xc*5��ɣ�����������xi-1���������������Ϊ�������е���Сֵ
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(dp[a] * 2, dp[b] * 3), dp[c] * 5);
            dp[i] = min;
            if (dp[a] * 2 == min) a++;
            if (dp[b] * 3 == min) b++;
            if (dp[c] * 5 == min) c++;
        }
        return dp[n - 1];
    }
}