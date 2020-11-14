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
    * 改进：使用双指针，可以不用计算链表长度
    */
    public ListNode getKthFromEnd(ListNode head, int k) {
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