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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //��ȡ��ǰ���еĳ��ȣ���������൱�� ��ǰ��һ��Ľڵ����
			int size = queue.size();
			List<Integer> tmp = new ArrayList<Integer>();
			//�������е�Ԫ�ض��ó���(Ҳ���ǻ�ȡ��һ��Ľڵ�)���ŵ���ʱlist��
			//����ڵ����/��������Ϊ�գ�Ҳ���������
			for(int i=0; i<size; ++i) {
				TreeNode t = queue.remove();
				tmp.add(t.val);
				if(t.left!=null) {
					queue.add(t.left);
				}
				if(t.right!=null) {
					queue.add(t.right);
				}
			}
			//����ʱlist�������շ��ؽ����
			res.add(tmp);
        }
        return res;
    }
}