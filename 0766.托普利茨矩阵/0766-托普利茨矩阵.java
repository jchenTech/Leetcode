class Solution {
    /**.
    * �����������Ԫ��
    * ����������ϵ����µĶԽ���Ԫ����ȣ���ô���ǿ��Եó����ɣ�
    * ����������Ԫ�����Ϸ����ҷ�������Ԫ��ʱ������Ԫ����ȣ���Ϊ�������ľ��� 
    * ��˱���ʱ����ȥ��һ�к����һ�н��б���
    */
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && j < matrix[0].length - 1 && matrix[i - 1][j] != matrix[i][j + 1]) {
                    return false;
                }else{
                    continue;
                }
            }
        }
        return true;
    }
}