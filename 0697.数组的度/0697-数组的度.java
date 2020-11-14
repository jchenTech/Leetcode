class Solution {
    /**
    * ӵ����ͬ��С�Ķȵ�����������������βԪ�ض�ӦΪӵ�����ȵ�Ԫ��
    * ���ֻ��Ҫ�ҵ���һ������Ԫ�غ����һ��Ԫ�ص�λ�ã����ɼ������������ĳ���
    * ����ʹ��HashMap����Ԫ�س��ִ�����Ԫ���״γ������������һ�γ�������
    */
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        
        Map<Integer, Integer> count = new HashMap<>();//�洢Ԫ���������г��ִ���
        Map<Integer, Integer> firstIndex = new HashMap<>();//Ԫ�����������״γ��ֵ�����
        Map<Integer, Integer> lastIndex = new HashMap<>(); //Ԫ���������������ֵ�����

        for(int i = 0; i < nums.length; i++) {
            int x = nums[i];
            count.put(x, count.getOrDefault(x, 0) + 1);//���Ԫ����hashmap��δ���ֹ�����Ĭ��ֵΪ0+1
            lastIndex.put(x, i);
            if (!firstIndex.containsKey(x)) {//���hashmap�в���Ԫ��x�����״γ��ֵ�����Ϊi����������򲻸���
                firstIndex.put(x, i);
            }
        }

        //ͳ������Ϊ����
        int max = 0;
        for(int num : nums) {
            if (count.get(num) > max) {
                max = count.get(num);
            }
        }
        
        //ӵ����ͬ������Ԫ�ؿ����ж�������Ҫ�Ƚ����ǵ�����������Ĵ�С
        int shortestLen = nums.length;
        for(int num : nums) {
            if (count.get(num) == max) {
                int len = lastIndex.get(num) - firstIndex.get(num) + 1;
                if (len < shortestLen) {
                    shortestLen = len; //��ͬ����Ԫ����������������̵ĳ���
                }
            }
        }
        
        return shortestLen;

    }
}