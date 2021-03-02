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
    //Ѱ�ҵ�K��Ľڵ㣬����ͨ��������������������л��
    //Ϊ���ڱ�������K��ڵ�ʱ��ǰ���أ���˿���ͨ�������������+�ж�kֵ�÷���ʵ��
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        // ����������ǰ�ڵ��ǵ�k���ڵ㣬�����ݹ飬����¼��ǰ�ڵ��ֵ
        if (--k == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }

}