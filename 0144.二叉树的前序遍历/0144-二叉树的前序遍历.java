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
    //�����ⷨ
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //1.��ʼ��ջ�������ڵ���ջ
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            //2.����ջ��Ԫ�أ�����ֵ��ӵ�����У���ʱrootΪ������Ľڵ�
            TreeNode node = stack.pop();
            res.add(node.val);

            //3.��� node ���������ǿգ�����������ջ��
            // ��� node ���������ǿգ�����������ջ����Ϊ��ջ�Ǻ���ȳ�
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }
}