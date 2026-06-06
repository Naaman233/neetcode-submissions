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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        PriorityQueue<ListNode> queue = 
        new PriorityQueue<>((a,b) -> {
            return a.val - b.val;
        });

        while ( list1 != null) {
            queue.offer(list1);
            list1 = list1.next;
        }

        while ( list2 != null) {
            queue.offer(list2);
            list2 = list2.next;
        }

        if (queue.isEmpty()) {
            return null;
        }

        ListNode result = queue.poll();
        ListNode current = result;

        while ( !queue.isEmpty()) {
            current.next = queue.poll();
            current = current.next;
        }

        current.next = null;
        return result;
    }
}