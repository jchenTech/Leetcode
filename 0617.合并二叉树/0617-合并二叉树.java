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
    * 在原有树上进行覆盖，不另外创建空间
    * 递归三部曲模板：
    * 1. 终止条件是什么： 当t1为空，t2不为空时，返回t2，放t1不为空或t1,t2都为空时，返回t1
    * 2. 找到返回值：返回值为当前这一级合并好后的二叉树
    * 3. 本级递归应该做什么：得到合并好了的左右子树，然后将根节点val相加
    */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 != null) {
            return t2;
        }
        if ((t1 != null && t2 == null) || (t1 == null && t2 == null)) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}