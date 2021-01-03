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
    * 1. ��ֹ������ʲô�� ��rootΪ��ʱ����ȻΪfalse;��root������������Ϊ�գ���root.val=sumʱ������true
    * 2. �ҵ�����ֵ������ֵΪ��ǰ��һ�������Ƿ���sum-root.val��·��
    * 3. �����ݹ�Ӧ����ʲô��������������Ƿ���·���ڵ�ֵ��ӵ���sum-root.val������У��򷵻�true
    */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}