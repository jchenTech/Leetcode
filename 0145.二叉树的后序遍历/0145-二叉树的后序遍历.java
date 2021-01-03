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
        //1.初始化栈，将根节点入栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            //2.弹出栈顶元素，并将值添加到结果中，此时node为弹出后的节点
            TreeNode node = stack.pop();
            //此处巧妙的地方为：将node.val值插入列表时，设置在index=0位置插入，
            //后面的元素向后移位，便可以达到反转遍历顺序的目的
            list.add(0, node.val);
            
            //3.前序遍历时入栈顺序为右子树先入，左子树后入，因为出栈时左子树能先出，遍历的顺序为中左右
            // 后序遍历需要的顺序为左右中，我们将左右子树的入栈顺序调换后，遍历顺序为中右左，将顺序反转后即为左右中。
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