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
    //使用先序遍历+判断深度得方法比较容易想到，但是时间复杂度较高，因此采用后序遍历+剪枝得方法进行优化
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