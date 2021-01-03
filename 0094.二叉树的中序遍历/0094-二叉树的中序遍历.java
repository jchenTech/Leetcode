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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        //1.��ʼ��ջ
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            
            //2.��ڵ���ջ
            if (node != null) {
                stack.push(node);
                node = node.left;
            }else {
                //3.��ջ��Ԫ��Ϊ������Ԫ��ʱ��1.ջ��Ԫ�س�ջ����ӵ�list����У�2.Ѱ���ҽڵ���б���
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}