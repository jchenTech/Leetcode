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
        //1.初始化栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            
            //2.左节点入栈
            if (node != null) {
                stack.push(node);
                node = node.left;
            }else {
                //3.当栈顶元素为最左侧的元素时，1.栈顶元素出栈，添加到list结果中，2.寻找右节点进行遍历
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}