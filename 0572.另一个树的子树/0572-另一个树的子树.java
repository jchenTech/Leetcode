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
    * 树t是树s的子树，只有三种情况：
    * 1、t与s相同
    * 2、t是s.left的子树
    * 3、t是s.right的子树
    */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isEqual(s, t);
    }

    private boolean isEqual(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }
        if (t == null || s == null) {
            return false;
        }
        return isEqual(s.left, t.left) && isEqual(s.right, t.right) && s.val == t.val;
    }
}