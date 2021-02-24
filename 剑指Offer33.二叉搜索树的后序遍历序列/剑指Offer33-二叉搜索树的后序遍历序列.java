class Solution {
    /**
    终止条件：i>=j，即当树的节点数量<=1的时候，为二叉搜索树，返回true
    递推工作：1、划分左右子树；2、判断是否为二叉搜索树
    返回值： p==j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1)
    */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        //终止条件：i>=j，即当树的节点数量为1的时候，为二叉搜索树，返回true
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        //m为后序遍历序列中根节点右子树的第一个比根节点大的节点，以此为左右子树的中界
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        //i-j是否为二叉搜索树的后序遍历序列为：
        //右子树m-j之间是否均大于j(左子树遍历时已证明小于)；左右子树是否为二叉搜索树
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}