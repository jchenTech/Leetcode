/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
    * 双重递归，定义一个递归先序遍历树，另一个递归计算从当前节点出发的给定长度的路径数量
    */
    private int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        pathSumHelper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }
    
    private void pathSumHelper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum == root.val) {
            count++;
        }
        pathSumHelper(root.left, sum - root.val);
        pathSumHelper(root.right, sum - root.val);
    }
}