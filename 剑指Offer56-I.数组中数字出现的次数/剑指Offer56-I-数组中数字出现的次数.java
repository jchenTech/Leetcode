class Solution {
    //要求时间复杂度是O(n)，空间复杂度是O(1)！！！
    //采用位运算，相同的数得异或^为0，且满足交换律，因此a^a^x^b^b^y的结果为x^y
    //当一个数组中只有一个出现一次的数时，我们可以直接的到结果，因此我们把x和y划分到两个数组中就可以得出结果
    //我们通过&与运算，循环左移判断n&m，计算m，得到为1的那一位m，然后将这一位与其他数运算，相同的数自然会被分到一组
    public int[] singleNumbers(int[] nums) {
        if (nums.length == 2) return nums;
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums) {//1.遍历异或
            n ^= num;
        }
        while ((n & m) == 0) {//2.循环左移，计算m
            m <<= 1;
        }
        for (int num : nums) {//3.遍历nums分组
            if ((m & num) != 0) x ^= num;//4.当num&m!=0
            else y ^= num;//5.当num & m == 0
        }
        return new int[] {x, y};
    }
}