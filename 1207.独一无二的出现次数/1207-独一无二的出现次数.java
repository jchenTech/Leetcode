class Solution {
    /**
    * 1. ͳ��������ÿ�����ĳ��ִ�����������hashmap1�棬keyΪ�����е�����valΪ�����ִ���
    * 2. ���ÿ�����ĳ��ִ���û���ظ��ģ��򷵻�true, hashmap2��keyΪÿ�������ִ�����valΪ���ִ����Ĵ���
    */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int key : map.keySet()) {
            map2.put(map.get(key), map2.getOrDefault(map.get(key), 0) + 1);
            if (map2.get(map.get(key)) > 1) {
                return false;
            }
        }
        return true;

    }
}