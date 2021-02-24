class Solution {
    /**
    ‘.’出现正确情况：只出现一次，且在e的前面
    ‘e’出现正确情况：只出现一次，且出现前有数字
    ‘+’‘-’出现正确情况：只能在开头和e后一位
    */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                //判定为数字，则标记numFlag
                numFlag = true;
            }else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                //判定为.  需要没出现过.并且没出现过e
                dotFlag = true;
            }else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && numFlag && !eFlag) {
                //判定为e，需要没出现过e，并且出过数字了
                eFlag = true;
                numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                
            }else {
                return false;
            }
        }
        return numFlag;
    }
}