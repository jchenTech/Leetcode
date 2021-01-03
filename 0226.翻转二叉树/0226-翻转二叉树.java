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
    * 1.找终止条件：当root为空时终止，返回root
    * 2.找返回值：返回的是当前这一级的已经翻转好了的树
    * 3.这一级递归做什么：翻转当前的树
    */
    public TreeNode invertTree(TreeNode root) {
        //1.终止条件
        if(root == null) {
            return root;
        }
        //3.这一级递归要做什么：翻转左右子树，并将左右子树进行交换
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        //2.找到返回值：返回翻转好了的这一级的树
        return root;
    }
}