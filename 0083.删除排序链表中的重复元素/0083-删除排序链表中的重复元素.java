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
    *  迭代法:创建一个tmp指针，遍历链表，当tmp值与tmp.next值相同时，将tmp.next指向后一位节点tmp.next.next
    * 当tmp值与tmp.next值不同时，将指针移动到下一，当tmp.next为空时退出循环，返回head
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