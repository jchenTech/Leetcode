class Solution {
    /** ʹ�ù�ϣ���������е�ÿ��Ԫ�أ��ж��Ƿ��ڹ�ϣ���У�
    * �����ڹ�ϣ�����򷵻أ�������������ӵ���ϣ���С�
    */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> dict = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (dict.contains(nums[i])) {
                return nums[i];
            }
            dict.add(nums[i]);
        }
        return -1;
    }
}