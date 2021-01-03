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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //1.��ʼ��ջ�������ڵ���ջ
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            //2.����ջ��Ԫ�أ�����ֵ��ӵ�����У���ʱnodeΪ������Ľڵ�
            TreeNode node = stack.pop();
            //�˴�����ĵط�Ϊ����node.valֵ�����б�ʱ��������index=0λ�ò��룬
            //�����Ԫ�������λ������Դﵽ��ת����˳���Ŀ��
            list.add(0, node.val);
            
            //3.ǰ�����ʱ��ջ˳��Ϊ���������룬���������룬��Ϊ��ջʱ���������ȳ���������˳��Ϊ������
            // ���������Ҫ��˳��Ϊ�����У����ǽ�������������ջ˳������󣬱���˳��Ϊ�����󣬽�˳��ת��Ϊ�����С�
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            
        }
        return list;
    }
}