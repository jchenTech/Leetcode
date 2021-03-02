class Solution {
    public int sumNums(int n) {
        //逻辑运算符的短路效应：
        //if(A && B) 此时如果A为false，则B不会执行，造成短路
        //if(A || B) 此时如果A为true，则B不会执行，造成短路
        boolean x =  n > 1 && (n +=sumNums(n - 1)) > 0;
        return n;
    }
}