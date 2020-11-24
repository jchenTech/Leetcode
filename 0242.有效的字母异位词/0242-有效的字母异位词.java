class Solution {
    /* 
     * ����һ������Ϊ26����ĸ���飬�����������Ӧ��26����ĸ
     * �����е�ֵ��Ӧÿ����ĸ�ĸ������������ַ����������ַ��ĸ�����һ��ʱ����true
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