class Solution {
    /**该题采用双指针进行循环遍历，当左指针为偶数及右指针为奇数时停下交换
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