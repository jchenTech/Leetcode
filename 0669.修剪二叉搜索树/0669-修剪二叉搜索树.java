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
    * �ݹ�������ģ��
    * 1������ֹ��������rootΪ��ʱ����ֹ������null
    * 2���ҷ���ֵ�����ص��ǵ�ǰ��һ���ݹ��Ѿ��޽��õĶ���������
    * 3����һ���ݹ�Ӧ����ʲô��
    * 3.1�����޽�root���ڵ㣬��root.val����[low, high]����ʱ����Ҫ�޼���
    * ��root.val < low ��root��root����������С��low�������޼����������
    * ��root.val > high ��root��root������������high�������޼����������
    * 3.2���޼�������
    * 3.3���޼�������
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