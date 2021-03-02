class Solution {
    public String reverseWords(String s) {
        //将string以" "空格拆分
        String[] strs = s.trim().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = strs.length - 1; i >= 0; i--) {
            //以空格为分割符完成字符串分割后，若两单词间有x个空格，
            //则在单词列表中，此两单词间会多出x-1个 “空单词” （即 "" ）
            if (strs[i].equals("")) {
                continue; 
            }
            sb.append(strs[i] + " ");
        }
        return sb.toString().trim();
    }
}