class Solution {
    //�����ⷨ����ÿ����������һ�����飬Ѱ�ұ�����С��������ʱ�临�Ӷ�O(N2)
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