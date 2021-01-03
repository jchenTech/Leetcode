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
    * �ݹ�������ģ�壺
    * 1. ��ֹ������ʲô�� ��rootΪ��ʱ������Ϊƽ�������
    * 2. �ҵ�����ֵ��BST�������ǣ�������������ΪBST�����������ĸ߶Ȳ����1�����������Ҫ������Ϣ
    * 3. �����ݹ�Ӧ����ʲô��
    */

    //���ݵڶ��������Ƿ�������Ҫ����������ΪBST�Ҹ߶Ȳ����1�жϵ�ǰ�ڵ��Ƿ�ʱBST
    //������ǹ���һ������������Ϣ:��������Ⱥ����Ƿ�ΪBST��ReturnNode��
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
        //1. ��ֹ���������ڵ�Ϊ��ʱ����ȻΪBST
        if(root == null) {
            //2. ����ֵ���������������Ƿ�Ϊ�������͸߶Ȳ���Ϣ��ReturnNode
            return new ReturnNode(0, true);
        }

        //3.�����ݹ�Ӧ����ʲô��Ӧ���ж����������������Ƿ�Ϊƽ����������Ҹ߶Ȳ��Ƿ񳬹�1

        ReturnNode left = isBalancedHelper(root.left);
        ReturnNode right = isBalancedHelper(root.right);
        
        //�������������в���BST��
        if(left.isBST == false || right.isBST == false) {
            return new ReturnNode(0, false);
        }
        //���������߶Ȳ����1
        if(Math.abs(left.depth - right.depth) > 1) {
            return new ReturnNode(0, false);
        }
        //����������3�������˵��ƽ���ˣ��������Ϊ����������������+1
        return new ReturnNode(Math.max(left.depth, right.depth) + 1, true);
    }










}