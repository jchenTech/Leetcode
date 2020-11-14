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
    * ��������
    * 1. �ҵ������е�
    * 2. ���е��ұ�������
    * 3. �ж��������Ƿ���ȫ��ͬ
    */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        //1.�ҵ������е�
        ListNode mid = findMidNode(head);
        ListNode head2 = mid.next;
        mid.next = null;

        //2.�ұߵ�������
        ListNode reversedHead = reverseList(head2);
        
        //3. �Ƚ����������Ƿ���ͬ
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

    //���ÿ���ָ��Ѱ�������е�
    private ListNode findMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //����˫ָ���������������
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