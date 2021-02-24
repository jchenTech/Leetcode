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
    /**对称二叉树的条件——任意两节点：
    1、L.val=R.val;
    2、L.left.val=R.right.val;
    3、L.right.val=R.left.val;
    考虑从顶至底递归，判断每对节点是否对称，从而判断树是否为对称二叉树。
    注意：不能通过root的左右子树分别是对称的以及左右节点值相同判定为对称！！
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