class Solution {
    public String reverseWords(String s) {
        //��string��" "�ո���
        String[] strs = s.trim().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = strs.length - 1; i >= 0; i--) {
            //�Կո�Ϊ�ָ������ַ����ָ���������ʼ���x���ո�
            //���ڵ����б��У��������ʼ����x-1�� ���յ��ʡ� ���� "" ��
            if (strs[i].equals("")) {
                continue; 
            }
            sb.append(strs[i] + " ");
        }
        return sb.toString().trim();
    }
}