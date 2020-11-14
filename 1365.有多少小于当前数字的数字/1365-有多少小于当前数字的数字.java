class Solution {
    //暴力解法，对每个数都遍历一次数组，寻找比其数小的数量，时间复杂度O(N2)
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int lessNum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    lessNum++;
                }
            }
            res[i] = lessNum;
        }
        return res;
    }
}