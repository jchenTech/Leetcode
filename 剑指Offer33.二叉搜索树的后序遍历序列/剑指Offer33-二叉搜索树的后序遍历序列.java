class Solution {
    /**
    ��ֹ������i>=j���������Ľڵ�����<=1��ʱ��Ϊ����������������true
    ���ƹ�����1����������������2���ж��Ƿ�Ϊ����������
    ����ֵ�� p==j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1)
    */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        //��ֹ������i>=j���������Ľڵ�����Ϊ1��ʱ��Ϊ����������������true
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        //mΪ������������и��ڵ��������ĵ�һ���ȸ��ڵ��Ľڵ㣬�Դ�Ϊ�����������н�
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        //i-j�Ƿ�Ϊ�����������ĺ����������Ϊ��
        //������m-j֮���Ƿ������j(����������ʱ��֤��С��)�����������Ƿ�Ϊ����������
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}