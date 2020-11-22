class Solution {
    /*
     * ����һ��indexָ�룬��¼����Ԫ��Ӧ��ŵ�λ�ã��������鵱��Ϊ��ʱ
     * nums[index] = nums[i]������nums[i]��Ϊ0
    */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int j = index; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}