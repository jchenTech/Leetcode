class Solution {
    //Ϊ��֤ʱ�临�Ӷȣ����ö��ַ�����
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        while (left < nums.length  && nums[left++] == target) {
            count++;
        }
        return count;
    }
}