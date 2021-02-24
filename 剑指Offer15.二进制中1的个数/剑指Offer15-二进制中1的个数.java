public class Solution {
    // you need to treat n as an unsigned value
    //巧用n&(n-1)， n&(n-1)意思为消除数字n最右边的1
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res += 1;
        }
        return res;
    }
}