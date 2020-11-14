class Solution {
    /*采用计数排序*/
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] frequency = new int[1001];
        for (int n : arr1) {
            frequency[n] += 1;
        }
        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            int count = frequency[arr2[i]];
            while (count > 0) {
                arr1[j] = arr2[i];
                j++;
                count--;
            }

            frequency[arr2[i]] = 0;
        }
        for (int k = 0; k < frequency.length; k++) {
            int count2 = frequency[k];
            while (count2 > 0) {
                arr1[j] = k;
                j++;
                count2--;
            }
        }
        return arr1;
    }
}