class Solution {
    /**
    * ����������i��λ��ʱ����������з�Ϊ�飬��ǰi��λ�õ����ֵһ������i��
    * ����һ���б�iС�������ֵ�����Ŀ飬�ǿ������һ������������
    */
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                res++;
            }
        }
        return res;
    }
}