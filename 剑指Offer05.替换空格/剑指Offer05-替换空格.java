class Solution {
    /** 方法一：
     * 将字符串存储到字符数组中，因为空格替换为3个字符，所以数组长度为字符串的3倍
     * 最后将得到的数组转换为字符串
     */ 
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0; //替换后字符串（字符数组）的长度
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }else {
                array[size++] = c;
            }
        }
        String newString = new String(array, 0, size);
        return newString;
    }

    /** 方法二：
     *  使用java内置方法String.replace进行替换
    
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
    */
}