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
    /**�Գƶ����������������������ڵ㣺
    1��L.val=R.val;
    2��L.left.val=R.right.val;
    3��L.right.val=R.left.val;
    ���ǴӶ����׵ݹ飬�ж�ÿ�Խڵ��Ƿ�Գƣ��Ӷ��ж����Ƿ�Ϊ�Գƶ�������
    ע�⣺����ͨ��root�����������ֱ��ǶԳƵ��Լ����ҽڵ�ֵ��ͬ�ж�Ϊ�Գƣ���
    */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
        
    }
    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetricHelper(left.right, right.left) && isSymmetricHelper(left.left, right.right); 
    }
}