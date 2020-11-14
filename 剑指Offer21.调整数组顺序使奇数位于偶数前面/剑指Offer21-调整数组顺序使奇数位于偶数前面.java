class Solution {
    /**�������˫ָ�����ѭ������������ָ��Ϊż������ָ��Ϊ����ʱͣ�½���
     */
    public int[] exchange(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length -1;
        
        while(left < right) {
            while (left < right && (nums[left] & 1) != 0) {
                left++;
            }
            while (left < right && (nums[right] & 1) != 1) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}