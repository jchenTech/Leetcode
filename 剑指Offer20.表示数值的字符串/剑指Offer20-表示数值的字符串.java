class Solution {
    /**
    ��.��������ȷ�����ֻ����һ�Σ�����e��ǰ��
    ��e��������ȷ�����ֻ����һ�Σ��ҳ���ǰ������
    ��+����-��������ȷ�����ֻ���ڿ�ͷ��e��һλ
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
                //�ж�Ϊ���֣�����numFlag
                numFlag = true;
            }else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                //�ж�Ϊ.  ��Ҫû���ֹ�.����û���ֹ�e
                dotFlag = true;
            }else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && numFlag && !eFlag) {
                //�ж�Ϊe����Ҫû���ֹ�e�����ҳ���������
                eFlag = true;
                numFlag = false;//Ϊ�˱���123e�������󣬳���e֮��ͱ�־Ϊfalse
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                
            }else {
                return false;
            }
        }
        return numFlag;
    }
}