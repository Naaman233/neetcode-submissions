class Solution {
    public int[][] merge(int[][] intervals) {
        
        LinkedList<int[]> res = new LinkedList<int[]>();
        if (intervals == null){
            return null;
        }
        Arrays.sort(intervals,(a,b)-> {
            return a[0] - b[0];
        });

        for (int[] n : intervals) {
            if (res.isEmpty() || res.getLast()[1] < n[0]) {
                res.add(n);
            }else{
                res.getLast()[1] = Math.max(res.getLast()[1], n[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
