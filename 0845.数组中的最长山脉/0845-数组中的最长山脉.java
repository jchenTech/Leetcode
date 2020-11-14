class Solution {
    /**
    * 先找到比左右两边大的数(山顶)，然后从山顶往左右两边进行查找
    */
    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        
        int maxLen = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                int len = 3;
                int l = i - 1;
                int r = i + 1;
                while ((l - 1) >= 0 && A[l - 1] < A[l]) {
                    len++;
                    l--;
                }

                while ((r + 1) <= A.length - 1 && A[r + 1] < A[r]) {
                    len++;
                    r++;
                }
                
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}