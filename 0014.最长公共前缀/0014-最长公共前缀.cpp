class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.empty())
            return "";
        string res = strs[0];
        for(int i=1;i<strs.size();i++)
        {
            for(int j=0;j<res.length();j++)
            {
                if(res[j]==strs[i][j])
                    continue;
                else
                {
                    res.erase(j);
                    break;
                }
            }
        }
        return res;
            
    }
};