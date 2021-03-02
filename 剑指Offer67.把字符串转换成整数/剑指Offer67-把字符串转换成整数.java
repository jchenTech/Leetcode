class Solution {
    public int strToInt(String str) {
        boolean negative = false;
        long res = 0;
        int i = 0;
        //循环遍历直到出现第一个数字
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == ' ') {//空格跳过，进行下一次循环
                i++;
                continue;
            }else if (c == '-' || c == '+') {//正负号判定后面一位是否跟数字，若不是则返回0
                if (i < str.length() - 1 && str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9') {
                    if (c == '-') {
                        negative = true;
                    }
                    i++;
                    break;
                }else {
                    return 0;
                }
            }else if (c >= '0' && c <= '9') {//遇到第一个数字则break
                break;
            }else {//其他字符如英文等直接返回0
                return 0;
            }
        }

        //从i开始遍历数字，当不为数字时返回
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                res *= 10;
                res += c - '0';
                //过程中如果数字大于int范围，则根据正负号返回最大或最小值
                if (res > Integer.MAX_VALUE) return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }else {
                break;
            }
            i++;
        }
        return negative ? (int) -res : (int) res;
    }
}