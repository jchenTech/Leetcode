class Solution {
    /**ʹ�õݹ鷽������ʱ�������� 
    int constant = 1000000007;
    public int fib(int n) {
        if (n < 2){
            return n;
        }
        int ans = (fib(n-1) + fib(n-2)) % constant; //�˴���Ϊ�˱�����ѭ���������ڴ����
        return ans;
    }
    */ 
    
    /** ʹ��ѭ�� */ 
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