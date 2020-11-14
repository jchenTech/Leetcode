class Solution {
    /**
    * 返回false的条件：
    * 1. 输入的字符串typed中含有name中不包含的字符
    * 2. 字符顺序不符合
    * 
    * 返回true的条件：
    * 1. name字符串的字符按顺序出现在typed中，若存在长按的情况则必须是前一个字符
    * 2. 输入的字符串typed中不含有name中不包含的字符
    * 
    * 使用双指针，对typed字符串进行循环遍历
    * 1. 若typed.charAt(j) == name.charAt(i)则为正确输入：i++并j++
    * 2. 若typed.charAt(j) == typed.charAt(j - 1)则为长按的情况，j++
    * 3. 其他情况则为错按，返回false，若循环结束没有返回false则为true
    */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (j < typed.length()) {
            if (i < name.length() && typed.charAt(j) == name.charAt(i)) {//正常输入
                i++;
                j++;
            }else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {//长按的情况
                j++;
            }else{
                return false;
            }
        }
        return i == name.length();
    }
}