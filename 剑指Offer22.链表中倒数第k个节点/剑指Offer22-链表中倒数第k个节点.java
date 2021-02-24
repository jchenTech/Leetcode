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
    * �Ľ���ʹ��˫ָ�룬���Բ��ü���������,
    * former����k����Ȼ��former��latterͬʱ��ʼ�ߣ���formerΪnullʱ��latter�պ��ߵ�������k�ڵ�
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