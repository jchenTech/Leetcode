/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /** 先计算链表长度n，通过n-k确定链表头节点位置 
    * 改进：使用双指针，可以不用计算链表长度,
    * former先走k步，然后former和latter同时开始走，当former为null时，latter刚好走到倒数第k节点
    */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode former = head;
        ListNode latter = head;
        while (k > 0) {
            former = former.next;
            k--;
        }
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}