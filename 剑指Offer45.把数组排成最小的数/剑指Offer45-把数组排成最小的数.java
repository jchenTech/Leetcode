class Solution {
    //ƴ��ʱ����˳��ȡ���ڣ���λС�����ȣ�����λ��ͬ���Ƚϵ�λ����˰��ո�˳��������������
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
    
    private void quickSort(String[] strs, int left, int right) {
        if (left > right) return;
        int pivotIndex = partition(strs, left, right);
        quickSort(strs, left, pivotIndex - 1);
        quickSort(strs, pivotIndex + 1, right);
    }

    private int partition(String[] strs, int left, int right) {
        String pivot = strs[left];
        int pivotIndex = left;
        while (left < right) {
            //����ĵط����������ַ�����ӣ���a+b>b+a����˵��a>b
            while (left < right && (strs[right] + pivot).compareTo(pivot + strs[right]) >= 0) {
                right--;
            }
            while (left < right && (strs[left] + pivot).compareTo(pivot + strs[left]) <= 0) {
                left++;
            }
            swap(strs, left, right);
        }
        swap(strs, pivotIndex, left);
        return left;
    }

    private void swap(String[] strs, int a, int b) {
        String tmp = strs[a];
        strs[a] = strs[b];
        strs[b] = tmp;
    }

}