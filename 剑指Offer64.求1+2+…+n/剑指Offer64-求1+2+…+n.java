class Solution {
    public int sumNums(int n) {
        //�߼�������Ķ�·ЧӦ��
        //if(A && B) ��ʱ���AΪfalse����B����ִ�У���ɶ�·
        //if(A || B) ��ʱ���AΪtrue����B����ִ�У���ɶ�·
        boolean x =  n > 1 && (n +=sumNums(n - 1)) > 0;
        return n;
    }
}