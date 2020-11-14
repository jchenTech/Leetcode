class Solution {
    public int[] sortByBits(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private int bitCount(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {//��Ϊ1ʱ����ʾn���һλ��������Ϊ1
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
        // ѡ��һ�����Ԫ�أ�һ��ѡ����߻������ұ�
        int temp = arr[hi];
        // ���������� cut �� i
        int cut = lo;
        // ��� arr[i] �� temp С�Ļ������� arr[i] �� arr[cut], Ȼ�� cut++
        // �зֵ�ʵ�ʾ��ǰ� temp �ŵ������к��ʵ�λ�ã���λ�õ��������� cut
        for (int i = lo; i < hi; i++) {
            // ��������� 1 �ĸ�����ȣ���Ƚ���������ʵ�ʴ�С
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