class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)-> {
            return a[1] - b[1];
        });
        int res = 1;
        int lastInterval = intervals[0][1];

        int n = intervals.length;
        for (int i = 1; i < n; i++) {

            if (intervals[i][0] >= lastInterval){
                res++;
                lastInterval = intervals[i][1];
            }
        }
        return n - res;
    }
}
