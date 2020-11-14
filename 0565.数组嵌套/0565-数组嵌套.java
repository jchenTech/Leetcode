class Solution {
    /**
    * n���ȵ������а���0-n-1�Ĳ��ظ����֣�ȡ��һ�������Ե�ǰ������Ϊ��һ�����ֵ��±꣬
    * ���Կ��������߼�ȡ�����������ջṹ��һ��Բ����ʣ�µ�����Ҳ����ܹ���Բ������������У�����������Բ����
    * ��ˣ���Ŀ����ת��Ϊ��һ��ͼ�д���һ������Բ��������������Բ�����ȡ���Բ���е�����Ԫ�س������õĽ����ͬ��
    * 
    * �������������飬������ֵ��ΪǶ��������±꣬������������ֵ��Ϊ-1
    */ 
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int index = i;
            while (nums[index] != -1){
                count++;
                int tmp = nums[index];
                nums[index] = -1;
                index = tmp;
            }
            res = Math.max(count, res);
        }
        return res;
    }
}