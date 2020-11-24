class Solution {
    /* 
     * 创建一个长度为26的字母数组，数组的索引对应于26个字母
     * 数组中的值对应每个字母的个数，当两个字符串中所有字符的个数都一致时返回true
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            if (alpha[t.charAt(j) - 'a'] == 0) {
                return false;
            }else {
                alpha[t.charAt(j) - 'a']--;
            }
        }
        return true;
    }
}