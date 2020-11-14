/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /** �ȼ���������n��ͨ��n-kȷ������ͷ�ڵ�λ�� 
    * �Ľ���ʹ��˫ָ�룬���Բ��ü���������
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