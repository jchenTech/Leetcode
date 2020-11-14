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
    * 回文链表：
    * 1. 找到链表中点
    * 2. 将中点右边链表反序
    * 3. 判断两链表是否完全相同
    */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        //1.找到链表中点
        ListNode mid = findMidNode(head);
        ListNode head2 = mid.next;
        mid.next = null;

        //2.右边的链表反序
        ListNode reversedHead = reverseList(head2);
        
        //3. 比较两个链表是否相同
        while (head != null && reversedHead != null) {
            if (head.val == reversedHead.val) {
                head = head.next;
                reversedHead = reversedHead.next;
            }else {
                return false;
            }
        }
        return true;

    }

    //利用快慢指针寻找链表中点
    private ListNode findMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //利用双指针迭代法反序链表
    private ListNode reverseList(ListNode head) {
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
}