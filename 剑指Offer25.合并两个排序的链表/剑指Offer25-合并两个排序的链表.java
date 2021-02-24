/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(-1);
        ListNode cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        //�ж�l2�Ƿ�Ϊ�գ���Ϊ��cur.nextΪl1ʣ�½ڵ㣬��֮Ϊl2ʣ�½ڵ�
        cur.next = l2 == null ? l1: l2; 
        return dum.next;
    }
}