class Solution {
    /*
     * 偶数和奇数个数相等，那把偶数位的都排好，剩下的奇数位自然而然就排好了
     */
public int[] sortArrayByParityII(int[] A) {
        if(A==null||A.length==0)return A;
        int odd=1;
        for (int i = 0; i < A.length; i+=2) {
            //如果是偶数，不操作
            if(A[i]%2==0)continue;
            //如果不是偶数，在奇数位里找一个偶数换过来
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