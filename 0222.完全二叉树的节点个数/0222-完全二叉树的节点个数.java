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
    public int countNodes(TreeNode root) {
        //计算树的高度，
        int height = treeHeight(root);
        //如果树是空的，或者高度是1，直接返回
        if (height == 0 || height == 1)
            return height;
        //如果右子树的高度是树的高度减1，说明左子树是满二叉树，
        //左子树可以通过公式计算，只需要递归右子树就行了
        if (treeHeight(root.right) == height - 1) {
            //注意这里的计算，左子树的数量是实际上是(1 << (height - 1))-1，
            //不要把根节点给忘了，在加上1就是(1 << (height - 1))
            return (1 << (height - 1)) + countNodes(root.right);
        } else {
            //如果右子树的高度不是树的高度减1，说明右子树是满二叉树，可以通过
            //公式计算右子树，只需要递归左子树就行了
            return (1 << (height - 2)) + countNodes(root.left);
        }
    }

    //计算树的高度
    private int treeHeight(TreeNode root) {
        return root == null ? 0 : 1 + treeHeight(root.left);
    }
}