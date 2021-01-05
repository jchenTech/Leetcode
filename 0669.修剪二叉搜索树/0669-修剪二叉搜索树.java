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
    * 递归三部曲模板
    * 1、找终止条件：当root为空时，终止，返回null
    * 2、找返回值：返回的是当前这一级递归已经修建好的二叉搜索树
    * 3、这一级递归应该做什么：
    * 3.1、先修建root根节点，当root.val不在[low, high]区间时，需要修剪：
    * 当root.val < low 则root和root的左子树都小于low，返回修剪后的右子树
    * 当root.val > high 则root和root右子树都大于high，返回修剪后的左子树
    * 3.2、修剪左子树
    * 3.3、修剪右子树
    */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}