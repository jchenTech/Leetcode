class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        //使用双指针i,j，用指针i遍历数组，用指针j记录非0元素的下标
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}