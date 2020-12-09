class Solution {
    /**
    * ������һ��list��Ԫ�ش�λ��ӵķ�������������һ��Ԫ�أ���
    *   1 2 1 0
    * + 0 1 2 1
    * = 1 3 3 1 ��Ϊ��һ��Ԫ�ص�ֵ 
    */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> lastRow = res.get(i-1);
            List<Integer> currentRow = new ArrayList<>();
            lastRow.add(0);
            currentRow.add(1);
            //��λ���
            for (int j = 0; j < i; j++) {
                currentRow.add(lastRow.get(j) + lastRow.get(j+1));
            }
            lastRow.remove(lastRow.size() - 1);
            res.add(currentRow);
        }
        return res;
    }
}