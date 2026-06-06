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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        Stack<ListNode> stack = new Stack();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode result = stack.pop();
        ListNode dummy = result;
        while (!stack.isEmpty()) {
            dummy.next = stack.pop();
            dummy = dummy.next;
        }

        dummy.next = null;
        return result;
    }
}
