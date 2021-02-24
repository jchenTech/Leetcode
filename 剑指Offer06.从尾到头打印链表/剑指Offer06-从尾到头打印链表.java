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
    递归模板：1、确定终止条件：当head为空时；
    2、找返回值，应该给上级返回什么
    3、本级递归应该做什么
    */
    ArrayList<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        list.add(head.val);
    }
}