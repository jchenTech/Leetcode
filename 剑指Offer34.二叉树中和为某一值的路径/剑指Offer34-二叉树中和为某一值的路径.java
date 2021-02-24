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
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>(); 
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    void recur(TreeNode root, int tar) {
        if(root == null) return;
        //·�����£����root�ڵ�ֵ
        path.add(root.val);
        //tarֵ����
        tar -= root.val;
        //��tarֵΪ0��root�ڵ�ΪҶ�ӽڵ�ʱres���path
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        //���ݹ�ﵽ��ֹ�����󣬼���root���ҿս���ɾ��Ҷ�ӽڵ㣬Ȼ�����
        path.removeLast();
    }
}