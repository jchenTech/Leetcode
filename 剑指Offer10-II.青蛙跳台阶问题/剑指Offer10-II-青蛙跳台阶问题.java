class Solution {
    /** 使用递归（超出时间限制！！！）
    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        return (numWays(n - 1) + numWays(n-2)) % 1000000007;
    }
    */
    
    /** 使用循环，避免超时 */
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}