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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null) {
            return false;
        }

        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b) -> {
            return a.start - b.start;
        });

        minHeap.addAll(intervals);
        Interval startingInterval = minHeap.poll();
        while (!minHeap.isEmpty()) {
            Interval currentInterval = minHeap.poll();
            if (startingInterval.end > currentInterval.start){
                return false;
            }else {
                startingInterval = currentInterval;
            }
        }

        return minHeap.isEmpty();
    }
}
