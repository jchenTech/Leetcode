class Solution {
    /** �������е�Ԫ��С�ڵ�һ��Ԫ��ʱ�����ظ�Ԫ�أ����򷵻ص�һ��Ԫ�� */
    public int minArray(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[0]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }
}