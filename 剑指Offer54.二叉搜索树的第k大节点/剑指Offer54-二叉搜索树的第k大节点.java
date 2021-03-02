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
    //寻找第K大的节点，可以通过二叉树的中序遍历序列获得
    //为了在遍历到第K大节点时提前返回，因此可以通过反向中序遍历+判定k值得方法实现
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        // 计数，若当前节点是第k个节点，结束递归，并记录当前节点的值
        if (--k == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }

}