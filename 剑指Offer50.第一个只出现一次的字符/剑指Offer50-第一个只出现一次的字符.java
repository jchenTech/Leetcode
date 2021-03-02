class Solution {
    public char firstUniqChar(String s) {
        //有序哈希表，根据插入顺序进行排序
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (int j = 0; j < s.length(); j++) {
            if (map.get(s.charAt(j)) == 1) return s.charAt(j);
        }
        return ' ';
    }
}