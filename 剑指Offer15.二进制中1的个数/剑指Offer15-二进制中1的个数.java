public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += 1;
            
            //n = n & (n - 1)ʹ��n�����ұߵ�1��Ϊ0��n & (n - 1)
            //ʹ�����ұߵ�1���ұߵ��������ֶ�Ϊ0
            n &= (n-1);
        }
        return count;
    }
}