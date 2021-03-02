class Solution {
    //Ҫ��ʱ�临�Ӷ���O(n)���ռ临�Ӷ���O(1)������
    //����λ���㣬��ͬ���������^Ϊ0�������㽻���ɣ����a^a^x^b^b^y�Ľ��Ϊx^y
    //��һ��������ֻ��һ������һ�ε���ʱ�����ǿ���ֱ�ӵĵ������������ǰ�x��y���ֵ����������оͿ��Եó����
    //����ͨ��&�����㣬ѭ�������ж�n&m������m���õ�Ϊ1����һλm��Ȼ����һλ�����������㣬��ͬ������Ȼ�ᱻ�ֵ�һ��
    public int[] singleNumbers(int[] nums) {
        if (nums.length == 2) return nums;
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums) {//1.�������
            n ^= num;
        }
        while ((n & m) == 0) {//2.ѭ�����ƣ�����m
            m <<= 1;
        }
        for (int num : nums) {//3.����nums����
            if ((m & num) != 0) x ^= num;//4.��num&m!=0
            else y ^= num;//5.��num & m == 0
        }
        return new int[] {x, y};
    }
}