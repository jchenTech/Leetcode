class Solution {
    /*
    * ��nums1�洢��set�У�Ȼ��Ա�nums2Ԫ���Ƿ������set�У������ظ��Ĵ���resSet��
    * ����resSetת��Ϊ���鼴��
    */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        for (int num1 : nums1) {
            set.add(num1);
        }

        for (int num2 : nums2) {
            if (set.contains(num2)) {
                resSet.add(num2);
            }
        }

        int[] res = new int[resSet.size()];
        Iterator it = resSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            res[i] = (int) it.next();
            i++;
        }
        return res;
    }
}