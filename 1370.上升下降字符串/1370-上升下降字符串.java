class Solution {
    /*
     * ÿһ��ѭ������Ҫ�����ַ�������С�Ļ������ַ�����˲���Ͱ�����ķ�ʽ
     * ����һ����ĸ���飬Ȼ������ѭ�������������ֵ��Сֵ
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