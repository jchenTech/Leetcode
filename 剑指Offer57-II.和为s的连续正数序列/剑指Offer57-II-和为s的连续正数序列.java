class Solution {
    //�������ڣ���ʼʱ�������ұ߽�l=1,r=2��������ֵ���<targetʱ��r++
    //��������ֵ>targetʱ��l++��������ʱ��ó�һ���⡣
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int l = 1, r = 1, sum = 0;
        while (l <= target / 2) {//��֦����Ϊ �ұ߽�һ��������߽磬��ˣ��� ��߽絽��Ŀ��ֵ��һ��󣬾Ͳ���Ҫ����������
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