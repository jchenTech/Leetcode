class Solution {
    /**
    * ��̬�滮˼·:Ҫʹ����С����Ƭ���ܹ�ƴ���γ�������Ƶ����ôҪ����0-T������
    * Ƭ��(clips[i][0], clips[i][1])�б�����clips[i][0]=0��clips[i][1]=T������
    * 1.��������Ѱ��clips[i][0]<=rightʱ��ǰ������right��������rightMax��len++
    * 2.ѭ����������ѭ������������rightMax >= T�����س���len+1
    * 3.���������һ�α�����right=rightMax�����Ƭ���г���һ�ο�ȱ���޷�������Ƶ������-1
    * ��right!=rightMax˵����Ƭ�γ���+1����ʱ��right����ΪrightMax
    */ 
    public int videoStitching(int[][] clips, int T) {
        if (clips.length == 0) {
            return -1;
        }

        int right = 0;
        int rightMax = 0;
        int len = 0;
        while (true) {
            //�����������飬�ҵ�clips[i][0]<=right��clips[i][1]����ֵrightMax
            for (int i = 0; i < clips.length; i++) {
                if (clips[i][0] <= right) {
                    rightMax = Math.max(clips[i][1], rightMax);
                    //���rightMax>=T��˵��Ƭ�ο��Ը�����Ƶ����len++
                    if (rightMax >= T) {
                        return len + 1;
                    }
                }
            }
            //��right == rightMax˵��Ƭ�ο�ͷ�м���β���ֿ�ȱ������-1;
            if (right == rightMax) {
                return -1;
            }else {//�����ȣ��򳤶ȼ�1��right= rightMax
                right = rightMax;
                len++;
            }    
        }
    }
}