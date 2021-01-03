/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
    * �ݹ�������ģ�壺
    * 1. ����ֹ���� 
    * 2. �ҵ�����ֵ
    * 3. �����ݹ�Ӧ����ʲô
    */
    public ListNode swapPairs(ListNode head) {
        //1. �ݹ�����Ϊ���������ʣһ���ڵ����û�нڵ�ʱ�������н���
        if (head == null || head.next == null) {
            return head;
        }
        //3. �����ݹ�Ӧ�ý���head��next��λ�ã�����swapPairs(next.next)Ϊ�Ѵ���õ�����
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        //2. ���ظ���һ���ݹ��Ѿ�����õ�����
        return next;
    }
}