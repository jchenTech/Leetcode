public class Solution {
    // you need to treat n as an unsigned value
    //����n&(n-1)�� n&(n-1)��˼Ϊ��������n���ұߵ�1
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res += 1;
        }
        return res;
    }
}