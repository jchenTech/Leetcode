class Solution {
    /*
     * 1.hashmap5存储以点离原点距离为键，以节点数组列表为值的键值对
     * 2.将节点距离添加到数组中
     * 3.对距离数组进行排序
     * 4.将前K个距离对应的节点数组添加到结果矩阵中，返回结果
     */
    public int[][] kClosest(int[][] points, int K) {
        Map<Double, List<int[]>> map = new HashMap<>();
        double[] dArray = new double[points.length];
        int[][] res = new int[K][2];
 
        for (int i = 0; i < points.length; i++) {
            double dist =  0.0;
            dist = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            dArray[i] = dist;
            if (!map.containsKey(dist)) {
                List<int[]> list = new ArrayList<>();
                list.add(points[i]);
                map.put(dist, list);
            }else {
                map.get(dist).add(points[i]);
            }
        }

        Arrays.sort(dArray);
        
        for (int j = 0; j < K; j++) {
            res[j] = map.get(dArray[j]).get(0);
            map.get(dArray[j]).remove(0);
        }
        return res;

    }
}