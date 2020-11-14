class Solution {
    /*
    * ����nums���飬��1-n�����У��������i��Ӧ��nums[|i|-1]��Ϊ�෴��
    * ��ԭ��Ϊ����Ϊ������ԭ��Ϊ������Ϊ������ֻ����һ�ε�Ԫ�غ�Ϊ���������
    * �ظ��������Ǹ���������ȱʧ����������dup + (len * (len + 1) / 2) -sum
    */
    public int[] findErrorNums(int[] nums) {
        int dup = -1;
        int miss = 1;
        int sum = 0;
        int len = nums.length;
        for(int n : nums) {
            if (nums[Math.abs(n) - 1] < 0) {
                dup = Math.abs(n);
            }else {
                nums[Math.abs(n) - 1] *= -1;
            }
            sum += Math.abs(n);
        }
        return new int[] {dup, dup + (len * (len + 1) / 2) -sum};
    }
}