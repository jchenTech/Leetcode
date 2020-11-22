class Solution {
    /*
     * 创建一个index指针，记录非零元素应存放的位置，遍历数组当不为零时
     * nums[index] = nums[i]，并将nums[i]置为0
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