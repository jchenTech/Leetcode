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
    * 第二小的节点情况为：
    * 1、当root的左右子节点值相同时，第二小节点为左右子节点的第二小节点的最小值
    * 2、当root的左右子节点值不同时，第二小节点为大节点值与小节点的第二小节点中的最小值
    */
    public int findSecondMinimumValue(TreeNode root) {
        //终止条件：返回值为-1的情况
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }
        if (root.left.val == root.right.val && root.left.left == null && root.right.left == null) {
            return -1;
        }

        int leftValue = root.left.val;
        int rightValue = root.right.val;

        if (root.left.val == root.val) {
            leftValue = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val) {
            rightValue = findSecondMinimumValue(root.right);
        }

        //如果左右值都不为-1，则返回最小值
        if (leftValue != -1 && rightValue != -1) {
            return Math.min(leftValue, rightValue);
        }
        if (leftValue == -1) {
            return rightValue;
        }
        return leftValue;
    }

}