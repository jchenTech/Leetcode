class Solution {
public:
    bool isPalindrome(int x) {
        int y;
        int init = x;
        long long result=0;
        while (x!=0)
        {
            y = x % 10;
            result = result * 10;
            result = y + result;
            x = x/10;
        }
        if (result != init || init<0)
        {
            return false;
        }
        else
            return true;
    }
};