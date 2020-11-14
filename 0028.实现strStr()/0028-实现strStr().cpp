class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.empty())
            return 0;
        int j = 0;
        int i = 0;
        for(i=0;i<haystack.size();++i)
        {
            if(j == needle.size())
                return i-needle.size();
            if(haystack[i] == needle[j])
            {
                j++;
            }
            else
            {
                i-=j;
                j=0;
            }
            
        }
        if (j==needle.size()){//ÅÐ¶ÏÍê³É
            return i - needle.size();
        }
        return -1;
            
    }
};