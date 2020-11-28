class Solution {
    /*
     * 每一次循环都需要查找字符串中最小的或最大的字符，因此采用桶计数的方式
     * 创建一个字母数组，然后两次循环遍历加入最大值最小值
     * 
     */
    public String sortString(String s) {
        int[] alpha = new int[26];
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
        }
        while (res.length() < s.length()){
            for (int j = 0; j < 26; j++) {
                if (alpha[j] > 0) {
                    res += (char) (j + 'a');
                    alpha[j]--;
                }
            }
            for (int k = 25; k >= 0; k--) {
                if (alpha[k] > 0) {
                    res += (char) (k + 'a');
                    alpha[k]--;
                }
            }
        }
        return res;
    }
}