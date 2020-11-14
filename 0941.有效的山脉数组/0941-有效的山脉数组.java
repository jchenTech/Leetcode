class Solution {
    /*
     * 定义双指针，从开头和结尾往中间进行遍历，如果遍历的局部最大值位置相同，则为山脉数组
     * 若遍历的局部最大值位置不同，则返回false
    */
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int i = 0;
        int j = A.length - 1;
        while (i < A.length - 1) {
            if (A[i] < A[i + 1]) {
                i++;
            }else if (A[i] == A[i + 1]) {
                return false;
            }else {
                break;
            }
        }
        
        while (j > 0) {
            if (A[j] < A[j - 1]) {
                j--;
            }else if (A[j] == A[j - 1]) {
                return false;
            }else {
                break;
            }
        }

        if (i == j && i != 0 && i != A.length - 1) {
            return true;
        }else {
            return false;
        }
    }
}