class Solution {
    //首尾双指针遍历数组，当首指针为奇数，尾指针为偶数都继续遍历
    //当首指针为偶数，尾指针为奇数时，调换两元素顺序
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        return nums;
    }
}