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
    //看题，树为二叉搜索树！
    //p,q都为root左树，则最近祖先为lowestCommonAncestor(root.left, p, q)
    //p,q都为root右树，则最近祖先为lowestCommonAncestor(root.right, p, q)
    //当p,q在root两端时，最近祖先为root
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null; 
        }
        if (p.val < root.val && q.val < root.val) {
            root = lowestCommonAncestor(root.left, p, q);
        }else if (p.val > root.val && q.val > root.val) {
            root = lowestCommonAncestor(root.right, p, q);
        }else {
            return root;
        }
        return root;
    }
}