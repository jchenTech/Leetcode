public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += 1;
            
            //n = n & (n - 1)使得n中最右边的1变为0，n & (n - 1)
            //使得最右边的1到右边的所有数字都为0
            n &= (n-1);
        }
        return count;
    }
}