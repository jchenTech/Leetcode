class Solution {
    /*
     * 当k个区间具有相同的交集时，则可以用一个弓箭引爆，因此对比两个区间的交集后，即删除这两个
     * 区间，保留交集区间即可。先排序然后比较
     */
    public int findMinArrowShots(int[][] points) {
        //边界条件判断
        if (points == null || points.length == 0)
            return 0;
        //按照每个气球的左边界排序
        Arrays.sort(points, (a, b) -> a[0] > b[0] ? 1 : -1);
        //获取排序后最后一个气球左边界的位置，我们可以认为是箭射入的位置
        int last = points[points.length - 1][0];
        //统计箭的数量
        int count = 1;
        for (int i = points.length - 1; i >= 0; i--) {
            //如果箭射入的位置大于下标为i这个气球的右边位置，说明这支箭不能
            //击爆下标为i的这个气球，需要再拿出一支箭，并且要更新这支箭射入的
            //位置
            if (last > points[i][1]) {
                last = points[i][0];
                count++;
            }
        }
        return count;
    }
}