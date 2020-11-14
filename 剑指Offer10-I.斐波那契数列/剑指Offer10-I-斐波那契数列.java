class Solution {
    /**使用递归方法（超时！！！） 
    int constant = 1000000007;
    public int fib(int n) {
        if (n < 2){
            return n;
        }
        int ans = (fib(n-1) + fib(n-2)) % constant; //此处是为了避免在循环过程中内存溢出
        return ans;
    }
    */ 
    
    /** 使用循环 */ 
    int constant = 1000000007;
    public int fib(int n) {
        if (n < 2){
            return n;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = (a + b) % constant;
            a = temp;
        }
        return b;
    }
}