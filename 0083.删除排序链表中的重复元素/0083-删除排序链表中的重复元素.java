/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
    *  ������:����һ��tmpָ�룬����������tmpֵ��tmp.nextֵ��ͬʱ����tmp.nextָ���һλ�ڵ�tmp.next.next
    * ��tmpֵ��tmp.nextֵ��ͬʱ����ָ���ƶ�����һ����tmp.nextΪ��ʱ�˳�ѭ��������head
    */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
            }else {
                tmp = tmp.next;
            }
        }
        return head;
    }
}