class Solution {
    /** ����һ��
     * ���ַ����洢���ַ������У���Ϊ�ո��滻Ϊ3���ַ����������鳤��Ϊ�ַ�����3��
     * ��󽫵õ�������ת��Ϊ�ַ���
     */ 
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0; //�滻���ַ������ַ����飩�ĳ���
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

    /** ��������
     *  ʹ��java���÷���String.replace�����滻
    
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
    */
}