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
    // 0为不偷 1为偷
    public int rob(TreeNode root) {
        int[] res = helper(root); //res存储root节点偷/不偷能获得的最大钱数
        return Math.max(res[0],res[1]);
    }
    public int[] helper(TreeNode root){
        if(root==null)  return new int[2]; //偷或者不偷结果都为0
        int[] res = new int[2];
        
        int[] left = helper(root.left); //左节点偷/不偷能获得的最大钱数
        int[] right = helper(root.right); //右节点偷/不偷能获得的最大钱数

        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]); //若不偷这个节点
        res[1] = root.val + left[0] + right[0];  //若偷这个节点

        return res;
    }
}