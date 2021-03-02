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
     * �������������������
     * ˼·��
     * ���������
     * 1��p q һ���������� һ���������� ��ô��ǰ�ڵ㼴�������������
     * 2��p q ���������� 
     * 3��p q ����������
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            // p q һ������һ������
            return root;
        }
        if (left != null) {
            // p q ����������
            return left;
        }
        if (right != null) {
            // p q ����������
            return right;
        }
        return null;
    }
}