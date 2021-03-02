class Solution {
    //二分法查找
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            //i位上的数字应该是i，否则就是发生了错位
            if (nums[mid] == mid) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}