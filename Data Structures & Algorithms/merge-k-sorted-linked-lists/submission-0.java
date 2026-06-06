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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)-> {
            return a.val - b.val;
        });

        int n = lists.length;
        for (int i = 0; i < n; i++) {

            ListNode dummy = lists[i];
            while (dummy != null){
                minHeap.offer(dummy);
                dummy = dummy.next;
            }
        }

        ListNode result = minHeap.poll();
        ListNode current = result;

        if (minHeap.isEmpty()) {
            return null;
        }

        while (!minHeap.isEmpty()) {

            current.next = minHeap.poll();
            current = current.next;
        }

        current.next = null;
        return result;
    }
}
