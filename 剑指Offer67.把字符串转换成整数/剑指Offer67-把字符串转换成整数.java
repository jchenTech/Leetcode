class Solution {
    public int strToInt(String str) {
        boolean negative = false;
        long res = 0;
        int i = 0;
        //ѭ������ֱ�����ֵ�һ������
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == ' ') {//�ո�������������һ��ѭ��
                i++;
                continue;
            }else if (c == '-' || c == '+') {//�������ж�����һλ�Ƿ�����֣��������򷵻�0
                if (i < str.length() - 1 && str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9') {
                    if (c == '-') {
                        negative = true;
                    }
                    i++;
                    break;
                }else {
                    return 0;
                }
            }else if (c >= '0' && c <= '9') {//������һ��������break
                break;
            }else {//�����ַ���Ӣ�ĵ�ֱ�ӷ���0
                return 0;
            }
        }

        //��i��ʼ�������֣�����Ϊ����ʱ����
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                res *= 10;
                res += c - '0';
                //������������ִ���int��Χ������������ŷ���������Сֵ
                if (res > Integer.MAX_VALUE) return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }else {
                break;
            }
            i++;
        }
        return negative ? (int) -res : (int) res;
    }
}