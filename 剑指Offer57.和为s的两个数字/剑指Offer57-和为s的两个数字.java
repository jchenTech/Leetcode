class Solution {
    //�������򣬲�����βָ��
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && (nums[left] + nums[right]) > target) {
                right--;
            }
            while (left < right && (nums[left] + nums[right]) < target) {
                left++;
            }
            if ((nums[left] + nums[right]) == target) {
                return new int[] {nums[left], nums[right]};
            }
        }
        return new int[2];
    }
}