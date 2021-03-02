class Solution {
    //滑动窗口，初始时窗口左右边界l=1,r=2，窗口数值相加<target时，r++
    //当窗口数值>target时，l++，当等于时则得出一个解。
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int l = 1, r = 1, sum = 0;
        while (l <= target / 2) {//剪枝：因为 右边界一定大于左边界，因此，当 左边界到达目标值的一半后，就不需要再向后查找了
            if (sum < target) {
                sum += r;
                r++;
            }else if (sum > target) {
                sum -= l;
                l++;
            }else {
                int[] arr = new int[r - l];
                for (int i = l; i < r; i++) {
                    arr[i - l] = i;
                } 
                list.add(arr);
                sum -= l;
                l++;
            }
        }
        int[][] res = new int[list.size()][];
        for (int j = 0; j < res.length; j++) {
            res[j] = list.get(j);
        }
        return res;
    }
}