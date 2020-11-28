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
    public int countNodes(TreeNode root) {
        //�������ĸ߶ȣ�
        int height = treeHeight(root);
        //������ǿյģ����߸߶���1��ֱ�ӷ���
        if (height == 0 || height == 1)
            return height;
        //����������ĸ߶������ĸ߶ȼ�1��˵��������������������
        //����������ͨ����ʽ���㣬ֻ��Ҫ�ݹ�������������
        if (treeHeight(root.right) == height - 1) {
            //ע������ļ��㣬��������������ʵ������(1 << (height - 1))-1��
            //��Ҫ�Ѹ��ڵ�����ˣ��ڼ���1����(1 << (height - 1))
            return (1 << (height - 1)) + countNodes(root.right);
        } else {
            //����������ĸ߶Ȳ������ĸ߶ȼ�1��˵������������������������ͨ��
            //��ʽ������������ֻ��Ҫ�ݹ�������������
            return (1 << (height - 2)) + countNodes(root.left);
        }
    }

    //�������ĸ߶�
    private int treeHeight(TreeNode root) {
        return root == null ? 0 : 1 + treeHeight(root.left);
    }
}