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
    * 递归：当且仅当以下三种情况下B时A的子结构：
    1、B是A的左子树的子结构
    2、B是A的右子树的子结构
    3、B是A的包含根节点相同的子结构
    */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null && (isSubStructure(A.left, B) || isSubStructure(A.right, B) || recur(A, B)));
    }
    
    /**recur函数，计算B是否为节点A为根节点的子树
    */
    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}