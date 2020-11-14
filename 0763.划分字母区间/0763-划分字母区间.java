class Solution {
    /**
    * 划分条件：1. 每个划分的字符串中不包含其他字符串包含的字符
    * 2. 划分的片段最多
    * 
    * 实现：考虑用数组代替HashMap记录字符最后一次出现的索引位置，减少开销
    * 1. 若该索引与当前位置索引相同，则说明该字符只出现了一次，应该单独划分为一个片段
    * 2. 若索引位置不同，则循环在这区间内其他字符的最后索引位置，记录索引最大值，以最大值划分片段
    */
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new LinkedList<>();

        //1. 首先用数组记录字符的最后索引位置
        int[] pos = new int[26];
        for (int i = 0; i < S.length(); i++) {
            pos[S.charAt(i) - 'a'] = i;
        }

        //2.遍历字符串，比较当前索引位置与该字符最后一次出现的索引位置
        int i = 0;
        while (i < S.length()) {
            int lastIndex = pos[S.charAt(i) - 'a'];
            //当前索引与最后索引相同，即字符串中只出现一次的字符，列表添加1
            if (i == lastIndex) {
                list.add(1);
                i++;
            }else {//存在重复元素，比较范围内其他元素的最后索引位置，找到最大索引，计算长度
                int maxIndex = lastIndex;
                for (int j = i; j < maxIndex; j++) {
                    int jLastIndex = pos[S.charAt(j) - 'a'];
                    if (jLastIndex > maxIndex){
                        maxIndex = jLastIndex;
                    }
                }
                list.add(maxIndex - i + 1);
                i = maxIndex + 1;
            }
        }
        return list;
    }
}