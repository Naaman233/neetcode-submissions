class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return distB - distA;
        });
        
        for (int[] point : points){
            queue.offer(point);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[][] result = new int[k][2];
        int index = 0;
        while (!queue.isEmpty()) {
            result[index++] = queue.poll();
        }

        return result;

    }
}
