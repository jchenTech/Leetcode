class Solution {
    /*
     * ż��������������ȣ��ǰ�ż��λ�Ķ��źã�ʣ�µ�����λ��Ȼ��Ȼ���ź���
     */
public int[] sortArrayByParityII(int[] A) {
        if(A==null||A.length==0)return A;
        int odd=1;
        for (int i = 0; i < A.length; i+=2) {
            //�����ż����������
            if(A[i]%2==0)continue;
            //�������ż����������λ����һ��ż��������
            while(A[odd]%2!=0){
                odd+=2;
            }
            swap(A,odd,i);
        }

        return A;
    }

    public void swap(int[] A,int x,int y){
        int temp=A[x];
        A[x]=A[y];
        A[y]=temp;
    }
}