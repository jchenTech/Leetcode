class Solution {
    //表格分区，根据表格的主对角线（全为1），
    //可将表格分为上三角和下三角两部分。然后迭代乘积上三角和下三角
    public int[] constructArr(int[] a) {
        if (a.length == 0) return new int[0];
        int[] b = new int[a.length];
        int tmp = 1;
        b[0] = 1;
        //计算下三角元素乘积，乘入b[i]
        for (int i = 1; i < b.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        //计算上三角元素乘积，记入tmp，然后乘入b[j]
        for (int j = b.length - 2; j >= 0; j--) {
            tmp *= a[j + 1];
            b[j] *= tmp;
        }
        return b;
    }
}