/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /** 方法一：辅助栈法
     * 将链表节点循环压入栈中，依靠栈后进先出的性质，将栈中节点打印
     */
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] array = new int [size];
        for (int i = 0; i < size; i++) {
            array[i] = stack.pop().val;
        }
        return array;
    }
    
    /** 方法二：递归法
    * 使用head.next循环递归head节点,当为空时返回，并回溯将节点值添加到
    * 列表中，然后将列表中的值赋给数组并返回
    ArrayList<Integer> temp = new ArrayList<>();
    public int[] reversePrint(ListNode head){
        recur(head);
        int[] res = new int[temp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
    
    public void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        temp.add(head.val);
    }
    */
}