/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        // Sort intervals by start time
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        // Min-heap to track the end times of meetings scheduled on the same day
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate over sorted intervals
        for (Interval meeting : intervals) {
            // If the earliest ending meeting ends before the current meeting starts, reuse the same day
            if (!minHeap.isEmpty() && minHeap.peek() <= meeting.start) {
                minHeap.poll(); // Free up the room (day)
            }

            // Add the end time of the current meeting to the heap
            minHeap.offer(meeting.end);
        }

        // The size of the heap is the minimum number of days required
        return minHeap.size();
    }
}
