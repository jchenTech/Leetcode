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
    * �ݹ�������ģ�壺
    * 1.����ֹ��������rootΪ��ʱ��ֹ������root
    * 2.�ҷ���ֵ�����ص��ǵ�ǰ��һ�����Ѿ���ת���˵���
    * 3.��һ���ݹ���ʲô����ת��ǰ����
    */
    public TreeNode invertTree(TreeNode root) {
        //1.��ֹ����
        if(root == null) {
            return root;
        }
        //3.��һ���ݹ�Ҫ��ʲô����ת�������������������������н���
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        //2.�ҵ�����ֵ�����ط�ת���˵���һ������
        return root;
    }
}