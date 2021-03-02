class Solution {
    //为顺子的条件：1、无重复的数，2、max-min<5
    //因此本题可以通过：Set+遍历和排序+遍历两种方法
    public boolean isStraight(int[] nums) {
        int joker = 0;
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) joker++;
            else if (nums[i] == nums[i+1]) return false;
        }
        return (nums[4] - nums[joker]) < 5;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (right < left) return;
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int pivotIndex = left;
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, left, pivotIndex);
        return left;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}