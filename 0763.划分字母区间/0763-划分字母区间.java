class Solution {
    /**
    * ����������1. ÿ�����ֵ��ַ����в����������ַ����������ַ�
    * 2. ���ֵ�Ƭ�����
    * 
    * ʵ�֣��������������HashMap��¼�ַ����һ�γ��ֵ�����λ�ã����ٿ���
    * 1. ���������뵱ǰλ��������ͬ����˵�����ַ�ֻ������һ�Σ�Ӧ�õ�������Ϊһ��Ƭ��
    * 2. ������λ�ò�ͬ����ѭ�����������������ַ����������λ�ã���¼�������ֵ�������ֵ����Ƭ��
    */
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new LinkedList<>();

        //1. �����������¼�ַ����������λ��
        int[] pos = new int[26];
        for (int i = 0; i < S.length(); i++) {
            pos[S.charAt(i) - 'a'] = i;
        }

        //2.�����ַ������Ƚϵ�ǰ����λ������ַ����һ�γ��ֵ�����λ��
        int i = 0;
        while (i < S.length()) {
            int lastIndex = pos[S.charAt(i) - 'a'];
            //��ǰ���������������ͬ�����ַ�����ֻ����һ�ε��ַ����б����1
            if (i == lastIndex) {
                list.add(1);
                i++;
            }else {//�����ظ�Ԫ�أ��ȽϷ�Χ������Ԫ�ص��������λ�ã��ҵ�������������㳤��
                int maxIndex = lastIndex;
                for (int j = i; j < maxIndex; j++) {
                    int jLastIndex = pos[S.charAt(j) - 'a'];
                    if (jLastIndex > maxIndex){
                        maxIndex = jLastIndex;
                    }
                }
                list.add(maxIndex - i + 1);
                i = maxIndex + 1;
            }
        }
        return list;
    }
}