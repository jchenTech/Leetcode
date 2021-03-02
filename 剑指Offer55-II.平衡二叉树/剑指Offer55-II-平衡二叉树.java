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
    //ʹ���������+�ж���ȵ÷����Ƚ������뵽������ʱ�临�ӶȽϸߣ���˲��ú������+��֦�÷��������Ż�
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return maxDepth(root) == -1 ? false : true;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        if (left == -1) return -1;
        int right = maxDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }
}