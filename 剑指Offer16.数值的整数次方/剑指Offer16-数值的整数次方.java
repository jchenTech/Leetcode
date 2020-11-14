class Solution {
    /** ��Ϊ���������> < = 0�������ۣ������˵ݹ�ķ������п���������
    * ���������ͬ���ǣ���Ϊ����ʱΪx*myPow(x*x, n/2)����ݹ���
    */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n > 0) {
            if (n == 1){
                return x;
            }
            if (n % 2 == 0) {//nΪż��
                return myPow(x * x, n / 2);
            }else {//nΪ����
                return x * myPow(x * x, n / 2);
            }
        }else if (n < 0) {
            return (1 / x) * myPow(1 / x, -(n + 1)); //��ֹ��n=-2^31ʱ��Ϊ-n���ڴ����
        }else {
            return 1.0;
        }
    }
}