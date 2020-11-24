class Solution {
    /*
     * ��k�����������ͬ�Ľ���ʱ���������һ��������������˶Ա���������Ľ����󣬼�ɾ��������
     * ���䣬�����������伴�ɡ�������Ȼ��Ƚ�
     */
    public int findMinArrowShots(int[][] points) {
        //�߽������ж�
        if (points == null || points.length == 0)
            return 0;
        //����ÿ���������߽�����
        Arrays.sort(points, (a, b) -> a[0] > b[0] ? 1 : -1);
        //��ȡ��������һ��������߽��λ�ã����ǿ�����Ϊ�Ǽ������λ��
        int last = points[points.length - 1][0];
        //ͳ�Ƽ�������
        int count = 1;
        for (int i = points.length - 1; i >= 0; i--) {
            //����������λ�ô����±�Ϊi���������ұ�λ�ã�˵����֧������
            //�����±�Ϊi�����������Ҫ���ó�һ֧��������Ҫ������֧�������
            //λ��
            if (last > points[i][1]) {
                last = points[i][0];
                count++;
            }
        }
        return count;
    }
}