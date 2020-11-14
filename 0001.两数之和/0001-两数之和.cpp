#include <iostream>
#include <vector>
using namespace std;

class Solution{
    public:
    vector<int> twoSum(vector<int>& nums, int target)
    {
        vector<int> TwoNum;
        int i,j;
        for(i=0;i<nums.size()-1;i++)
        {
            for(j=i+1;j<nums.size();j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    TwoNum.push_back(i);
                    TwoNum.push_back(j);
                    return TwoNum;
                }
            }
        }
        return TwoNum;
    };
};