class Solution {
    /**
    * 动态规划思路:要使得最小数量片段能够拼接形成完整视频，那么要包含0-T的数字
    * 片段(clips[i][0], clips[i][1])中必须有clips[i][0]=0和clips[i][1]=T的数组
    * 1.遍历矩阵寻找clips[i][0]<=right时当前数组中right最大的数，rightMax，len++
    * 2.循环遍历矩阵，循环结束条件：rightMax >= T，返回长度len+1
    * 3.当矩阵完成一次遍历后，right=rightMax则代表片段中出现一段空缺，无法覆盖视频，返回-1
    * 当right!=rightMax说明，片段长度+1，此时的right更新为rightMax
    */ 
    public int videoStitching(int[][] clips, int T) {
        if (clips.length == 0) {
            return -1;
        }

        int right = 0;
        int rightMax = 0;
        int len = 0;
        while (true) {
            //遍历整个数组，找到clips[i][0]<=right中clips[i][1]最大的值rightMax
            for (int i = 0; i < clips.length; i++) {
                if (clips[i][0] <= right) {
                    rightMax = Math.max(clips[i][1], rightMax);
                    //如果rightMax>=T，说明片段可以覆盖视频返回len++
                    if (rightMax >= T) {
                        return len + 1;
                    }
                }
            }
            //若right == rightMax说明片段开头中间或结尾出现空缺，返回-1;
            if (right == rightMax) {
                return -1;
            }else {//若不等，则长度加1，right= rightMax
                right = rightMax;
                len++;
            }    
        }
    }
}