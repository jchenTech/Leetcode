class Solution {
    /*
    * 将nums1存储到set中，然后对比nums2元素是否存在于set中，将不重复的存入resSet中
    * 最后把resSet转换为数组即可
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