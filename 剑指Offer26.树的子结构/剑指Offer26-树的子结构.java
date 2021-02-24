/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
    * �ݹ飺���ҽ����������������BʱA���ӽṹ��
    1��B��A�����������ӽṹ
    2��B��A�����������ӽṹ
    3��B��A�İ������ڵ���ͬ���ӽṹ
    */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null && (isSubStructure(A.left, B) || isSubStructure(A.right, B) || recur(A, B)));
    }
    
    /**recur����������B�Ƿ�Ϊ�ڵ�AΪ���ڵ������
    */
    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}