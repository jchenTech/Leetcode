class Solution {
public:
    int reverse(int x) {
        int y;
        long long result=0;
        while (x!=0)
        {
            y = x % 10;
            result = result * 10;
            result = y + result;
            x = x/10;
        }
        if (result < -2147483648 || result > 2147483647) {
            return 0;
        }
        return result;
    }
};