class Solution {
    /**
    * 1. 统计数组中每个数的出现次数，可以用hashmap1存，key为数组中的数，val为数出现次数
    * 2. 如果每个数的出现次数没有重复的，则返回true, hashmap2的key为每个数出现次数，val为出现次数的次数
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