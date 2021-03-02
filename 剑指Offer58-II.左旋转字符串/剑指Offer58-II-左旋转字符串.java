class Solution {
    public String reverseLeftWords(String s, int n) {
        if (s.length() == 1) return s;
        String str1 = s.substring(0, n);
        String str2 = s.substring(n, s.length());
        return str2 + str1;
    }
}