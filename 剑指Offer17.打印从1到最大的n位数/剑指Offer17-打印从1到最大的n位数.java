class Solution {
    public int[] printNumbers(int n) {
        int length = (int)Math.pow(10, n);
        int[] numbers = new int[length-1];
        for (int i = 0; i < length - 1; i++) {
            numbers[i] = i + 1; 
        }
        return numbers;
    }
}