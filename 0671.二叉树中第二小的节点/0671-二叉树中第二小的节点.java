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
    * �ڶ�С�Ľڵ����Ϊ��
    * 1����root�������ӽڵ�ֵ��ͬʱ���ڶ�С�ڵ�Ϊ�����ӽڵ�ĵڶ�С�ڵ����Сֵ
    * 2����root�������ӽڵ�ֵ��ͬʱ���ڶ�С�ڵ�Ϊ��ڵ�ֵ��С�ڵ�ĵڶ�С�ڵ��е���Сֵ
    */
    public int findSecondMinimumValue(TreeNode root) {
        //��ֹ����������ֵΪ-1�����
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }
        if (root.left.val == root.right.val && root.left.left == null && root.right.left == null) {
            return -1;
        }

        int leftValue = root.left.val;
        int rightValue = root.right.val;

        if (root.left.val == root.val) {
            leftValue = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val) {
            rightValue = findSecondMinimumValue(root.right);
        }

        //�������ֵ����Ϊ-1���򷵻���Сֵ
        if (leftValue != -1 && rightValue != -1) {
            return Math.min(leftValue, rightValue);
        }
        if (leftValue == -1) {
            return rightValue;
        }
        return leftValue;
    }

}