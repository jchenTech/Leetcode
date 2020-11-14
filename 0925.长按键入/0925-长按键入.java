class Solution {
    /**
    * ����false��������
    * 1. ������ַ���typed�к���name�в��������ַ�
    * 2. �ַ�˳�򲻷���
    * 
    * ����true��������
    * 1. name�ַ������ַ���˳�������typed�У������ڳ���������������ǰһ���ַ�
    * 2. ������ַ���typed�в�����name�в��������ַ�
    * 
    * ʹ��˫ָ�룬��typed�ַ�������ѭ������
    * 1. ��typed.charAt(j) == name.charAt(i)��Ϊ��ȷ���룺i++��j++
    * 2. ��typed.charAt(j) == typed.charAt(j - 1)��Ϊ�����������j++
    * 3. ���������Ϊ��������false����ѭ������û�з���false��Ϊtrue
    */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (j < typed.length()) {
            if (i < name.length() && typed.charAt(j) == name.charAt(i)) {//��������
                i++;
                j++;
            }else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {//���������
                j++;
            }else{
                return false;
            }
        }
        return i == name.length();
    }
}