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
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        longestPath(root);
        return ans;
    }
    //�ݹ麯�����ܣ���Ѱ��nodeΪ�����ֵͬ·��:Ҫô����nodeΪ������������Ҫô����nodeΪ����������
    public int longestPath(TreeNode node) {
        if (node == null) return 0;
        int maxLorRres=0;
        int left = longestPath(node.left); //node���������ֵͬ·��
        int right = longestPath(node.right);//node���������ֵͬ·��
        //�����������Ѱ���ֵͬ·�����а���������������rootΪ·����ʼ����·��û�а���
        if (node.left != null && node.left.val == node.val&&node.right != null && node.right.val == node.val) {
            ans=Math.max(ans, left + right+2);
        }
        //������������ѡ�����ֵͬ·��
        if(node.left!=null&&node.left.val == node.val){
            maxLorRres=left+1;
        }
        if(node.right!=null&&node.right.val==node.val){
            maxLorRres=Math.max(maxLorRres,right+1);
        }
        //��ans��maxLorRres�и������ֵ
        ans=Math.max(ans,maxLorRres);
        return maxLorRres; //��������֪��Ϊʲô�������ֵ����
    }

}
