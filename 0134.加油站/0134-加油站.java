class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int j = i;
            int count = 0;
            int capacity = 0;
            while(count < gas.length) {
                capacity += gas[j];
                capacity -= cost[j];
                if (capacity < 0) {
                    break;
                }
                if (j == gas.length-1) {
                    j = 0;
                }else{
                    j++;
                }
                count++;
            }
            if (count >= gas.length) {
                return i;
            }
        }
        return -1;
    }
}