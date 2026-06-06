class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a,b) -> {
            return a[0] - b[0];
        });

        for (int[] n: intervals) {
            minHeap.offer(n);
        }

        minHeap.offer(newInterval);
        
        /*
            [[1,3],[2,5],[4,6]]
        */
        int[] startingInterval = minHeap.poll();
        List<int[]> res = new ArrayList<int[]>();
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            if (startingInterval[1] >= current[0]) {
                startingInterval[1] = Math.max(startingInterval[1],current[1]);

            }else {
                res.add(startingInterval);
                startingInterval = current;
            }
        }
        res.add(startingInterval);
        return res.toArray(new int[res.size()][]);
    }
}
