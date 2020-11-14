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
    //创建全局变量减少参数的输入
    private Map<Integer, Integer> indexMap = new HashMap<>();;
    private int[] preorder;

    /** 使用递归的方法，由于根节点一定是在前序遍历中的第一个节点，所以
     * 根据根节点在中序遍历中的位置来将树分为左子树和右子树
     * 采用递归的方法分别对左右子树进行递归构建
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        if (preLen != inLen) {
            return null;
        }
        this.preorder = preorder;
        //由于需要获得根节点在中序遍历中的索引，使用HashMap牺牲空间换时间
        for (int i = 0; i < inLen; i++) {
            indexMap.put(inorder[i], i);
        } 
        return buildTreeHelper(0, preLen - 1, 0, inLen - 1);
    }

    /**
     * 根据前序遍历数组的 [preL, preR] 和 中序遍历数组的 [inL, inR] 重新组建二叉树
     *
     * @param preL 前序遍历数组的区间左端点
     * @param preR 前序遍历数组的区间右端点
     * @param inL  中序遍历数组的区间左端点
     * @param inR  中序遍历数组的区间右端点
     * @return 构建的新二叉树的根结点
    */

    private TreeNode buildTreeHelper(int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        int pivot = preorder[preL];
        //构建的新的二叉树的根节点一定是前序遍历的第一个节点
        TreeNode root = new TreeNode(pivot);

        int pivotIndex = indexMap.get(pivot);

        //需要在草稿纸上计算左子树和右子树的前序中序左右端节点索引
        root.left = buildTreeHelper(preL + 1, preL + pivotIndex - inL, inL, pivotIndex - 1);
        root.right = buildTreeHelper(preL + pivotIndex -inL + 1, preR, pivotIndex + 1, inR);
        return root;
    }
}