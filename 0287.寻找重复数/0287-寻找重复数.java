class Solution {
    //¿ìÂıÖ¸Õë
    public int findDuplicate(int[] nums) {
        int low = nums[0];
        int fast = nums[0];
        while (true) {
            low = nums[low];
            fast = nums[nums[fast]];
            if (low == fast){
                break;
            }
        }
        fast = nums[0];
        while (low != fast) {
            low = nums[low];
            fast = nums[fast];
        }
        return low;
    }
}