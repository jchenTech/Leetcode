class Solution {
    //�����������ݱ������Խ��ߣ�ȫΪ1����
    //�ɽ�����Ϊ�����Ǻ������������֡�Ȼ������˻������Ǻ�������
    public int[] constructArr(int[] a) {
        if (a.length == 0) return new int[0];
        int[] b = new int[a.length];
        int tmp = 1;
        b[0] = 1;
        //����������Ԫ�س˻�������b[i]
        for (int i = 1; i < b.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        //����������Ԫ�س˻�������tmp��Ȼ�����b[j]
        for (int j = b.length - 2; j >= 0; j--) {
            tmp *= a[j + 1];
            b[j] *= tmp;
        }
        return b;
    }
}