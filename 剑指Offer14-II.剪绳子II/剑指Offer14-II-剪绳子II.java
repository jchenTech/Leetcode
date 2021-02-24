class Solution {
    /**该题与剪绳子I类似，但是数据范围变了，使用动态规划求解时会超出int取值范围，因此采用贪心算法
    根据数学证明，当n拆分为2和3得数组合相乘时，乘积最大，并且3优先级高于2
    所以我们在计算n时，不断将n减去3,乘积结果乘3，最后剩下的数再与res相乘
    */
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int constant = 1000000007;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res = res % constant;
            n -= 3;
        }
        return (int) (res * n % constant);
    }
}