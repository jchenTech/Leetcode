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
    //����ȫ�ֱ������ٲ���������
    private Map<Integer, Integer> indexMap = new HashMap<>();;
    private int[] preorder;

    /** ʹ�õݹ�ķ��������ڸ��ڵ�һ������ǰ������еĵ�һ���ڵ㣬����
     * ���ݸ��ڵ�����������е�λ����������Ϊ��������������
     * ���õݹ�ķ����ֱ�������������еݹ鹹��
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        if (preLen != inLen) {
            return null;
        }
        this.preorder = preorder;
        //������Ҫ��ø��ڵ�����������е�������ʹ��HashMap�����ռ任ʱ��
        for (int i = 0; i < inLen; i++) {
            indexMap.put(inorder[i], i);
        } 
        return buildTreeHelper(0, preLen - 1, 0, inLen - 1);
    }

    /**
     * ����ǰ���������� [preL, preR] �� ������������ [inL, inR] �����齨������
     *
     * @param preL ǰ����������������˵�
     * @param preR ǰ���������������Ҷ˵�
     * @param inL  ������������������˵�
     * @param inR  �����������������Ҷ˵�
     * @return �������¶������ĸ����
    */

    private TreeNode buildTreeHelper(int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        int pivot = preorder[preL];
        //�������µĶ������ĸ��ڵ�һ����ǰ������ĵ�һ���ڵ�
        TreeNode root = new TreeNode(pivot);

        int pivotIndex = indexMap.get(pivot);

        //��Ҫ�ڲݸ�ֽ�ϼ�������������������ǰ���������Ҷ˽ڵ�����
        root.left = buildTreeHelper(preL + 1, preL + pivotIndex - inL, inL, pivotIndex - 1);
        root.right = buildTreeHelper(preL + pivotIndex -inL + 1, preR, pivotIndex + 1, inR);
        return root;
    }
}