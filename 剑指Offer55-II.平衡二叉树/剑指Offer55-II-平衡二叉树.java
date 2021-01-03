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
    * 递归三部曲模板：
    * 1. 终止条件是什么： 当root为空时，空树为平衡二叉树
    * 2. 找到返回值：BST的条件是，当左右子树都为BST且两个字树的高度差不超过1，因此我们需要两个信息
    * 3. 本级递归应该做什么：
    */

    //根据第二步，我们分析到需要当左右子树为BST且高度差不超过1判断当前节点是否时BST
    //因此我们构造一个返回两个信息:即树的深度和树是否为BST的ReturnNode类
    private class ReturnNode {
        boolean isBST;
        int depth;
        public ReturnNode(int depth, boolean isBST) {
            this.depth = depth;
            this.isBST = isBST;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root).isBST;
    }

    private ReturnNode isBalancedHelper(TreeNode root) {
        //1. 终止条件：当节点为空时，自然为BST
        if(root == null) {
            //2. 返回值：带有左右子树是否为二叉树和高度差信息的ReturnNode
            return new ReturnNode(0, true);
        }

        //3.本级递归应该做什么：应该判断左子树和右子树是否为平衡二叉树，且高度差是否超过1

        ReturnNode left = isBalancedHelper(root.left);
        ReturnNode right = isBalancedHelper(root.right);
        
        //左右子树其中有不是BST的
        if(left.isBST == false || right.isBST == false) {
            return new ReturnNode(0, false);
        }
        //左右子树高度差大于1
        if(Math.abs(left.depth - right.depth) > 1) {
            return new ReturnNode(0, false);
        }
        //不满足上面3种情况，说明平衡了，树的深度为左右俩子树最大深度+1
        return new ReturnNode(Math.max(left.depth, right.depth) + 1, true);
    }










}