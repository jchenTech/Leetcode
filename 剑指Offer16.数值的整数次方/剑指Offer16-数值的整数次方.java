class Solution {
    /** 分为三种情况，> < = 0进行讨论，采用了递归的方法进行快速幂运算
    * 其中情况不同的是，当为奇数时为x*myPow(x*x, n/2)代入递归中
    */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n > 0) {
            if (n == 1){
                return x;
            }
            if (n % 2 == 0) {//n为偶数
                return myPow(x * x, n / 2);
            }else {//n为奇数
                return x * myPow(x * x, n / 2);
            }
        }else if (n < 0) {
            return (1 / x) * myPow(1 / x, -(n + 1)); //防止当n=-2^31时变为-n后内存溢出
        }else {
            return 1.0;
        }
    }
}