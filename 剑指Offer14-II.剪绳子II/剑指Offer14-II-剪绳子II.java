class Solution {
    /**�����������I���ƣ��������ݷ�Χ���ˣ�ʹ�ö�̬�滮���ʱ�ᳬ��intȡֵ��Χ����˲���̰���㷨
    ������ѧ֤������n���Ϊ2��3����������ʱ���˻���󣬲���3���ȼ�����2
    ���������ڼ���nʱ�����Ͻ�n��ȥ3,�˻������3�����ʣ�µ�������res���
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