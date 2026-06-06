class Solution {
    public int swimInWater(int[][] grid) {
        
        int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};
        if (grid == null || grid.length == 0){
            return -1;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>((a,b)-> {
            return a.time - b.time;
        });
        queue.offer(new Node(grid[0][0], 0 , 0));
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Node currentPos = queue.poll();
            int time = currentPos.time;
            int row = currentPos.row;
            int col = currentPos.col;

            
            if (row == n -1 && col == n -1){
                return time;
            }

            for (int[] direction : directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < n  && newCol >= 0 && newCol < n  && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    queue.offer(new Node(Math.max(time,grid[newRow][newCol]), newRow, newCol));
                }
            }
            
        }

        return -1;
    }
}

class Node {
    int time;
    int row;
    int col;
    Node(int time,int row,int col){
        this.time = time;
        this.row = row;
        this.col = col;
    }
}
