class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int res = 0;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                res = Math.max(res,dfs(matrix,i,j));
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int i, int j) {
        int res = 1;
        
        int m = matrix.length , n = matrix[0].length;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] d : dir) {
            int newRow = i + d[0];
            int newCol = j + d[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n 
            && matrix[newRow][newCol] > matrix[i][j]) {
                res = Math.max(res,1 + dfs(matrix,newRow,newCol));
            }
        }

       return res; 
    }
}
