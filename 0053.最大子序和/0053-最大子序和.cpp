class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int size = nums.size();
        int dp[size];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i=1;i<size;i++){
            if(nums[i]+dp[i-1]>=nums[i]){
                dp[i] = nums[i]+dp[i-1];
            }
            else
                dp[i] = nums[i];
            if(dp[i] >= max)
                    max = dp[i];
        }
        return max;
    }
};