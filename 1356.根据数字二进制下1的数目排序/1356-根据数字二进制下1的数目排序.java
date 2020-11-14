class Solution {
    public int[] sortByBits(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private int bitCount(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {//当为1时，表示n最后一位二进制数为1
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    private void sort(int[] arr, int left, int right) {
        if (right < left) {
            return;
        }
        int pivotIndex = partition(arr, left, right);
        sort(arr, left, pivotIndex - 1);
        sort(arr, pivotIndex + 1, right);
    }

    private int partition(int[] arr, int lo, int hi) {
        // 选择一个标记元素，一般选最左边或者最右边
        int temp = arr[hi];
        // 两个索引， cut 和 i
        int cut = lo;
        // 如果 arr[i] 比 temp 小的话，交换 arr[i] 和 arr[cut], 然后 cut++
        // 切分的实质就是把 temp 放到数组中合适的位置，该位置的索引就是 cut
        for (int i = lo; i < hi; i++) {
            // 如果二进制 1 的个数相等，则比较两个数的实际大小
            if (bitCount(arr[i]) == bitCount(temp)) {
              if (arr[i]  < temp) {
                  swap(arr, i, cut);
                  cut++;
              }
            } else if (bitCount(arr[i]) < bitCount(temp)) {
                swap(arr, i, cut);
                cut++;
            }
        }
        swap(arr, cut, hi);
        return cut;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}