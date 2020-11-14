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
    * 方法二：寻找链表中点 + 链表逆序 + 合并链表
    * 1.寻找链表中点：使用快慢指针
    * 2.链表逆序：使用双指针迭代法
    * 3.合并链表：将两个链表合并
    */
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode l1 = head;
        ListNode l2 = head;

        ListNode mid = midNode(head);
        l2 = mid.next;
        mid.next = null;//将l1 l2两个链表分开

        l2 = reverseListNode(l2);
        MergeList(l1, l2);
        
    }
        
        private ListNode midNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while(fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode reverseListNode(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }
            return prev;
        }

        private void MergeList(ListNode l1, ListNode l2) {
            ListNode l1_tmp;
            ListNode l2_tmp;

            while (l1 != null && l2 != null) {
                l1_tmp = l1.next;
                l2_tmp = l2.next;

                l1.next = l2;
                l1 = l1_tmp;

                l2.next = l1;
                l2 = l2_tmp;
            }
        }
}