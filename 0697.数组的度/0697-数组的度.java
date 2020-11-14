class Solution {
    /**
    * 拥有相同大小的度的最短连续子数组的首尾元素都应为拥有最大度的元素
    * 因此只需要找到第一个最大度元素和最后一个元素的位置，即可计算出该子数组的长度
    * 考虑使用HashMap计算元素出现次数，元素首次出现索引和最后一次出现索引
    */
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        
        Map<Integer, Integer> count = new HashMap<>();//存储元素在数组中出现次数
        Map<Integer, Integer> firstIndex = new HashMap<>();//元素在数组中首次出现的索引
        Map<Integer, Integer> lastIndex = new HashMap<>(); //元素在数组中最后出现的索引

        for(int i = 0; i < nums.length; i++) {
            int x = nums[i];
            count.put(x, count.getOrDefault(x, 0) + 1);//如果元素在hashmap中未出现过，则默认值为0+1
            lastIndex.put(x, i);
            if (!firstIndex.containsKey(x)) {//如果hashmap中不含元素x，则首次出现的索引为i，如果包含则不更新
                firstIndex.put(x, i);
            }
        }

        //统计最大度为多少
        int max = 0;
        for(int num : nums) {
            if (count.get(num) > max) {
                max = count.get(num);
            }
        }
        
        //拥有相同度数的元素可能有多个，因此要比较他们的连续子数组的大小
        int shortestLen = nums.length;
        for(int num : nums) {
            if (count.get(num) == max) {
                int len = lastIndex.get(num) - firstIndex.get(num) + 1;
                if (len < shortestLen) {
                    shortestLen = len; //相同最大度元素中连续子数组最短的长度
                }
            }
        }
        
        return shortestLen;

    }
}