/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    private List<Node> list = new ArrayList<>();
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inOrderTraverse(root);
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                list.get(i).left = list.get(list.size() - 1);
            }else {
                list.get(i).left = list.get(i - 1);    
            }
            if (i == list.size() - 1) {
                list.get(i).right = list.get(0);
            }else {
                list.get(i).right = list.get(i + 1);
            }
        }
        return list.get(0);

    }
    
    private void inOrderTraverse(Node root) {
        if (root == null) return;
        inOrderTraverse(root.left);
        list.add(root);
        inOrderTraverse(root.right);
    }
}