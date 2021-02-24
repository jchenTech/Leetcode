class Solution {
    //正数：当n为偶数时，myPow(x, n) = myPow(x*x, n/2)
    //正数：当n为奇数时，myPow(x, n) = x*myPow(x*x, n/2)
    //负数：当n为负数时，myPow(x, n) = (1/x)*myPow(1/x, -(n+1))
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 0) {
            if (n == 1) {
                return x;
            }else if (n % 2 == 0) {
                return myPow(x * x, n / 2);
            }else {
                return x * myPow(x * x, n / 2);
            }
        }else {
            return (1/x)*myPow(1/x, -(n+1));
        }
    }
}