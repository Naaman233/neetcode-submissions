class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> {
            return a[0] - b[0];
        });

        // cost = 0 and index = 0
        queue.offer(new int[]{0,0});
        int count = 0, result = 0;
        int n = points.length;

        boolean[] visited = new boolean[n];

        while (count < n){
            int[] current = queue.poll();
            int cost = current[0];
            int indexOfPoint = current[1];

            if (visited[indexOfPoint]){
                continue;
            }

            visited[indexOfPoint] = true;
            result += cost;
            count++;

            //explore every possible node in the priority queue
            for (int i = 0; i < n; i++){
                int dist = manhattanDistance(points[i],points[indexOfPoint]);
                queue.offer(new int[]{dist,i});
            }
        }

        return result;

    }

    static int manhattanDistance(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}


//0 + 2 + 4 + 3 + 