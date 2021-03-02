class Solution {
    //���ַ�����
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            //iλ�ϵ�����Ӧ����i��������Ƿ����˴�λ
            if (nums[mid] == mid) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}