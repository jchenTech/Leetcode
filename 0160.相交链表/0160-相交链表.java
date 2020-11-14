/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
    * ��������ָ��, ��һ������������ĩβ�Ľڵ�ָ����һ�������ͷ��, ������������Ϊ����(�ڵ�һ���ƶ���ǡ��Ĩ���˳��Ȳ�)
    * ����ָ������ƶ�����ͬ�ľ���, �н���ͷ���, �޽�����Ǹ���������ָ��ĳ���
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}