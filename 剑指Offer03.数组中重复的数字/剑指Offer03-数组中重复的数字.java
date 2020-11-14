class Solution {
    /** 使用哈希表，对数组中的每个元素，判断是否在哈希表中，
    * 若存在哈希表中则返回；若不存在则添加到哈希表中。
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