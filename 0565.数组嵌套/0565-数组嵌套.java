class Solution {
    /**
    * n长度的数组中包含0-n-1的不重复数字，取出一个数字以当前数字作为下一个数字的下标，
    * 可以看出按此逻辑取出的数字最终会构成一个圆环，剩下的数字也如此能构成圆环，找最长的序列，就是找最大的圆环。
    * 因此，题目可以转换为，一个图中存在一个或多个圆环，求其中最大的圆环长度。从圆环中的任意元素出发所得的结果相同。
    * 
    * 操作：遍历数组，将数组值作为嵌套数组的下标，并将遍历过的值赋为-1
    */ 
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int index = i;
            while (nums[index] != -1){
                count++;
                int tmp = nums[index];
                nums[index] = -1;
                index = tmp;
            }
            res = Math.max(count, res);
        }
        return res;
    }
}