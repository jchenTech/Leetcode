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
    * 递归三部曲模板：
    * 1. 终止条件是什么： 当root为空时，显然为false;当root的左右子树均为空，且root.val=sum时，返回true
    * 2. 找到返回值：返回值为当前这一级的树是否有sum-root.val的路径
    * 3. 本级递归应该做什么：检查左右子树是否有路径节点值相加等于sum-root.val，如果有，则返回true
    */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}