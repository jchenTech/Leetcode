class Solution {
    /** 当数组中的元素小于第一个元素时，返回该元素；否则返回第一个元素 */
    public int minArray(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[0]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }
}