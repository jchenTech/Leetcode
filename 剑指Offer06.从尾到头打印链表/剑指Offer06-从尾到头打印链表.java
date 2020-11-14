/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /** ����һ������ջ��
     * ������ڵ�ѭ��ѹ��ջ�У�����ջ����ȳ������ʣ���ջ�нڵ��ӡ
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
    
    /** ���������ݹ鷨
    * ʹ��head.nextѭ���ݹ�head�ڵ�,��Ϊ��ʱ���أ������ݽ��ڵ�ֵ��ӵ�
    * �б��У�Ȼ���б��е�ֵ�������鲢����
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