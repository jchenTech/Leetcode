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
    //���⣬��Ϊ������������
    //p,q��Ϊroot���������������ΪlowestCommonAncestor(root.left, p, q)
    //p,q��Ϊroot���������������ΪlowestCommonAncestor(root.right, p, q)
    //��p,q��root����ʱ���������Ϊroot
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