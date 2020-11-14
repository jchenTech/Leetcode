class Solution {
    /*
    * 遍历nums数组，在1-n数字中，如果整数i对应的nums[|i|-1]改为相反数
    * 即原本为正改为负数，原本为复数改为正数。只出现一次的元素恒为负数，因此
    * 重复的数字是该正数，而缺失的数字则是dup + (len * (len + 1) / 2) -sum
    */
    public int[] findErrorNums(int[] nums) {
        int dup = -1;
        int miss = 1;
        int sum = 0;
        int len = nums.length;
        for(int n : nums) {
            if (nums[Math.abs(n) - 1] < 0) {
                dup = Math.abs(n);
            }else {
                nums[Math.abs(n) - 1] *= -1;
            }
            sum += Math.abs(n);
        }
        return new int[] {dup, dup + (len * (len + 1) / 2) -sum};
    }
}