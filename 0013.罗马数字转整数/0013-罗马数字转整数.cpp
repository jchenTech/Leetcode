class Solution {
public:
    int romanToInt(string s) {
        map<char,int> romanToInteger;//建立罗马表
        //插入对应关系
        romanToInteger.insert(map<char,int>::value_type('I',1));
        romanToInteger.insert(map<char,int>::value_type('V',5));
        romanToInteger.insert(map<char,int>::value_type('X',10));
        romanToInteger.insert(map<char,int>::value_type('L',50));
        romanToInteger.insert(map<char,int>::value_type('C',100));
        romanToInteger.insert(map<char,int>::value_type('D',500));
        romanToInteger.insert(map<char,int>::value_type('M',1000));
        
        int result = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            if(romanToInteger[s[i]]>=romanToInteger[s[i+1]])
            {
                result += romanToInteger[s[i]];
            }
            else
            {
                result += romanToInteger[s[i+1]]-romanToInteger[s[i]];
                i++;
            }
        }
        return result;
    }
};