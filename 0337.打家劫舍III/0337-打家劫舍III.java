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
    // 0Ϊ��͵ 1Ϊ͵
    public int rob(TreeNode root) {
        int[] res = helper(root); //res�洢root�ڵ�͵/��͵�ܻ�õ����Ǯ��
        return Math.max(res[0],res[1]);
    }
    public int[] helper(TreeNode root){
        if(root==null)  return new int[2]; //͵���߲�͵�����Ϊ0
        int[] res = new int[2];
        
        int[] left = helper(root.left); //��ڵ�͵/��͵�ܻ�õ����Ǯ��
        int[] right = helper(root.right); //�ҽڵ�͵/��͵�ܻ�õ����Ǯ��

        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]); //����͵����ڵ�
        res[1] = root.val + left[0] + right[0];  //��͵����ڵ�

        return res;
    }
}